package com.example.backend.business.dto.responses.create;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private int id;
    private String username;
    private String password;
    private String description;
    private String phoneNumber;
    private String emailAddress;
}

