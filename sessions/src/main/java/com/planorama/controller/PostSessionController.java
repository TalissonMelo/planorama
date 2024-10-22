package com.planorama.controller;

import com.planorama.controller.request.SessionRequest;
import com.planorama.domain.Session;
import com.planorama.service.PostSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostSessionController {

    private final PostSessionService service;

    @PostMapping("/sessions/users/{userId}")
    public ResponseEntity<List<Session>> execute(@PathVariable String userId,
                                                 @Valid @RequestBody SessionRequest request,
                                                 @RequestHeader(value = "timezone", required = true) String timezone) {

        List<Session> sessions = service.execute(userId, request, timezone);

        return ResponseEntity.status(201).body(sessions);

    }
}
