package com.example.backend.repository;

import com.example.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByEmailAddress(String emailAddress);
}
