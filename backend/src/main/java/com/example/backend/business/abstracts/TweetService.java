package com.example.backend.business.abstracts;

import com.example.backend.business.dto.requests.create.CreateTweetRequest;
import com.example.backend.business.dto.requests.update.UpdateTweetRequest;
import com.example.backend.business.dto.responses.create.CreateTweetResponse;
import com.example.backend.business.dto.responses.get.GetAllTweetsResponse;
import com.example.backend.business.dto.responses.get.GetTweetResponse;
import com.example.backend.business.dto.responses.update.UpdateTweetResponse;

import java.util.List;

public interface TweetService {
    List<GetAllTweetsResponse> getAll(int userId);
    GetTweetResponse getById(int tweetId);
    CreateTweetResponse add(CreateTweetRequest request);
    UpdateTweetResponse update(int tweetId, UpdateTweetRequest request);
    void delete(int tweetId);
}
