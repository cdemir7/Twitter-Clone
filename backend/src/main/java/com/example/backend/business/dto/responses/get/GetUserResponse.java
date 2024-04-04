package com.example.backend.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private int id;
    private String username;
    private String password;
    private String description;
    private String phoneNumber;
    private String emailAddress;
}
