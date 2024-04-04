package com.example.backend.business.rules;

import com.example.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private final UserRepository repository;

    public void checkIfUserExistsById(int id){
        if (!repository.existsById(id)){
            throw new RuntimeException("USER_NOT_EXISTS");
        }
    }

    public void checkIfUserExistsByPhoneNumber(String phoneNumber){
        if (repository.existsByPhoneNumber(phoneNumber)){
            throw new RuntimeException("USER_ALREADY_EXISTS");
        }
    }

    public void checkIfUserExistsByEmailAddress(String emailAddress){
        if (repository.existsByEmailAddress(emailAddress)){
            throw new RuntimeException("USER_ALREADY_EXISTS");
        }
    }
}
