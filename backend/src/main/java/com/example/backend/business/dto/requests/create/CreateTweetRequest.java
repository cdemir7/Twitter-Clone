package com.example.backend.business.dto.requests.create;

import com.example.backend.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTweetRequest {
    @NotNull
    private int userId;

    @NotBlank
    @Length(min = 1, max = 250)
    private String text;
}

