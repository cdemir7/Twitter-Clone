package com.example.backend.repository;

import com.example.backend.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
    List<Tweet> findAllByUserId(int userId);
}
