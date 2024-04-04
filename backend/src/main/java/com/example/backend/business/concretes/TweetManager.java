package com.example.backend.business.concretes;

import com.example.backend.business.abstracts.TweetService;
import com.example.backend.business.dto.requests.create.CreateTweetRequest;
import com.example.backend.business.dto.requests.update.UpdateTweetRequest;
import com.example.backend.business.dto.responses.create.CreateTweetResponse;
import com.example.backend.business.dto.responses.get.GetAllTweetsResponse;
import com.example.backend.business.dto.responses.get.GetTweetResponse;
import com.example.backend.business.dto.responses.update.UpdateTweetResponse;
import com.example.backend.business.rules.TweetBusinessRules;
import com.example.backend.entities.Tweet;
import com.example.backend.repository.TweetRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TweetManager implements TweetService {
    private final TweetRepository repository;
    private final ModelMapper mapper;
    private final TweetBusinessRules rules;

    @Override
    public List<GetAllTweetsResponse> getAll(int userId) {
        List<Tweet> tweets = repository.findAllByUserId(userId);
        List<GetAllTweetsResponse> responses = tweets
                .stream()
                .map(tweet -> mapper.map(tweet, GetAllTweetsResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetTweetResponse getById(int tweetId) {
        rules.checkITweetExistsById(tweetId);
        Tweet tweet = repository.findById(tweetId).orElseThrow();
        GetTweetResponse response = mapper.map(tweet, GetTweetResponse.class);

        return response;
    }

    @Override
    public CreateTweetResponse add(CreateTweetRequest request) {
        Tweet tweet = mapper.map(request, Tweet.class);
        tweet.setId(0);
        tweet.setCommentNumber(0);
        tweet.setLikeNumber(0);
        tweet.setCreationDate(LocalDateTime.now());
        Tweet createdTweet = repository.save(tweet);

        CreateTweetResponse response = mapper.map(createdTweet, CreateTweetResponse.class);

        return response;
    }

    @Override
    public UpdateTweetResponse update(int tweetId, UpdateTweetRequest request) {
        rules.checkITweetExistsById(tweetId);
        Tweet tweet = mapper.map(request, Tweet.class);
        tweet.setId(tweetId);
        tweet.setCreationDate(LocalDateTime.now());
        Tweet updatedTweet = repository.save(tweet);

        UpdateTweetResponse response = mapper.map(updatedTweet, UpdateTweetResponse.class);

        return response;
    }

    @Override
    public void delete(int tweetId) {
        rules.checkITweetExistsById(tweetId);
        repository.deleteById(tweetId);
    }
}
