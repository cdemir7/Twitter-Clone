package com.example.backend.api.controllers;

import com.example.backend.business.abstracts.UserService;
import com.example.backend.business.dto.requests.create.CreateUserRequest;
import com.example.backend.business.dto.requests.update.UpdateUserRequest;
import com.example.backend.business.dto.responses.create.CreateUserResponse;
import com.example.backend.business.dto.responses.get.GetAllUsersResponse;
import com.example.backend.business.dto.responses.get.GetUserResponse;
import com.example.backend.business.dto.responses.update.UpdateUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public List<GetAllUsersResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetUserResponse getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse add(@Valid @RequestBody CreateUserRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateUserResponse update(@PathVariable int id, @Valid @RequestBody UpdateUserRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
