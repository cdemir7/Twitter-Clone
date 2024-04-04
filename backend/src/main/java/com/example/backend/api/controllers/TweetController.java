package com.example.backend.api.controllers;

import com.example.backend.business.abstracts.TweetService;
import com.example.backend.business.dto.requests.create.CreateTweetRequest;
import com.example.backend.business.dto.requests.update.UpdateTweetRequest;
import com.example.backend.business.dto.responses.create.CreateTweetResponse;
import com.example.backend.business.dto.responses.get.GetAllTweetsResponse;
import com.example.backend.business.dto.responses.get.GetTweetResponse;
import com.example.backend.business.dto.responses.update.UpdateTweetResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tweets")
public class TweetController {
    private final TweetService service;

    @GetMapping("/{userId}")
    public List<GetAllTweetsResponse> getAll(@PathVariable int userId){
        return service.getAll(userId);
    }

    @GetMapping("/{tweetId}")
    public GetTweetResponse getById(@PathVariable int tweetId){
        return service.getById(tweetId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTweetResponse add(@Valid @RequestBody CreateTweetRequest request){
        return service.add(request);
    }

    @PutMapping("/{tweetId}")
    public UpdateTweetResponse update(@PathVariable int tweetId, @Valid @RequestBody UpdateTweetRequest request){
        return service.update(tweetId, request);
    }

    @DeleteMapping("/{tweetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int tweetId){
        service.delete(tweetId);
    }
}
