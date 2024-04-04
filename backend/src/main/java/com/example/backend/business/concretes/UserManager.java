package com.example.backend.business.concretes;

import com.example.backend.business.abstracts.UserService;
import com.example.backend.business.dto.requests.create.CreateUserRequest;
import com.example.backend.business.dto.requests.update.UpdateUserRequest;
import com.example.backend.business.dto.responses.create.CreateUserResponse;
import com.example.backend.business.dto.responses.get.GetAllUsersResponse;
import com.example.backend.business.dto.responses.get.GetUserResponse;
import com.example.backend.business.dto.responses.update.UpdateUserResponse;
import com.example.backend.business.rules.UserBusinessRules;
import com.example.backend.entities.User;
import com.example.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository repository;
    private final ModelMapper mapper;
    private final UserBusinessRules rules;
    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = repository.findAll();
        List<GetAllUsersResponse> responses = users
                .stream()
                .map(user -> mapper.map(user, GetAllUsersResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetUserResponse getById(int id) {
        rules.checkIfUserExistsById(id);
        User user = repository.findById(id).orElseThrow();
        GetUserResponse response = mapper.map(user, GetUserResponse.class);

        return response;
    }

    @Override
    public CreateUserResponse add(CreateUserRequest request) {
        rules.checkIfUserExistsByPhoneNumber(request.getPhoneNumber());
        rules.checkIfUserExistsByEmailAddress(request.getEmailAddress());
        User user = mapper.map(request, User.class);
        user.setId(0);
        User createdUser = repository.save(user);

        CreateUserResponse response = mapper.map(createdUser, CreateUserResponse.class);

        return response;
    }

    @Override
    public UpdateUserResponse update(int id, UpdateUserRequest request) {
        rules.checkIfUserExistsById(id);
        rules.checkIfUserExistsByPhoneNumber(request.getPhoneNumber());
        rules.checkIfUserExistsByEmailAddress(request.getEmailAddress());
        User user = mapper.map(request, User.class);
        user.setId(id);
        User updatedUser = repository.save(user);

        UpdateUserResponse response = mapper.map(updatedUser, UpdateUserResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfUserExistsById(id);
        repository.deleteById(id);
    }
}
