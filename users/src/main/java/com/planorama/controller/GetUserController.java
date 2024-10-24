package com.planorama.controller;

import com.planorama.model.Users;
import com.planorama.service.GetUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GetUserController {

    private final GetUsersService service;

    @GetMapping("/users/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Users> execute(@PathVariable String userId) {

        Users response = service.execute(userId);

        return ResponseEntity.status(200)
                .body(response);
    }

}
