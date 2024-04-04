package com.example.backend.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
    private int id;
    private String name;
    private String description;
    private String phoneNumber;
    private String emailAddress;
}
