package com.planorama.controller;

import com.planorama.controller.request.UserRequest;
import com.planorama.model.Users;
import com.planorama.service.PostUsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostUserController {

    private final PostUsersService service;

    @PutMapping("/users/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Users> execute(@PathVariable String userId,
                                         @Valid @RequestBody UserRequest request) {

        Users response = service.execute(userId, request);

        return ResponseEntity.status(200)
                .body(response);
    }

}
