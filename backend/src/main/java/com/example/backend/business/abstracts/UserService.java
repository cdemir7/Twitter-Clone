package com.example.backend.business.abstracts;

import com.example.backend.business.dto.requests.create.CreateUserRequest;
import com.example.backend.business.dto.requests.update.UpdateUserRequest;
import com.example.backend.business.dto.responses.create.CreateUserResponse;
import com.example.backend.business.dto.responses.get.GetAllUsersResponse;
import com.example.backend.business.dto.responses.get.GetUserResponse;
import com.example.backend.business.dto.responses.update.UpdateUserResponse;

import java.util.List;

public interface UserService {
    List<GetAllUsersResponse> getAll();
    GetUserResponse getById(int id);
    CreateUserResponse add(CreateUserRequest request);
    UpdateUserResponse update(int id, UpdateUserRequest request);
    void delete(int id);
}
