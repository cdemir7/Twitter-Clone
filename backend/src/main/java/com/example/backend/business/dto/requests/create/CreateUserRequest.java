package com.example.backend.business.dto.requests.create;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank
    @Length(max = 50, message = "İsim alanı 50 karakterden fazla olamaz.")
    private String name;

    private String description;

    @NotBlank
    @Length(min = 10, max = 10, message = "Telefon numarası 10 karaterden oluşmak zorundadır.")
    private String phoneNumber;

    @NotBlank
    private String emailAddress;
}
