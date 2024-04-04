package com.example.backend.business.rules;

import com.example.backend.repository.TweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TweetBusinessRules {
    private final TweetRepository repository;

    public void checkITweetExistsById(int tweetId){
        if (!repository.existsById(tweetId)){
            throw new RuntimeException("TWEET_NOT_EXISTS");
        }
    }


}
