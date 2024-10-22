package com.planorama.controller;

import com.planorama.controller.request.PutSessionRequest;
import com.planorama.service.PutSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PutSessionController {

    private final PutSessionService service;


    @PutMapping("/v1/sessions/{sessionId}")
    public ResponseEntity<Void> execute(@PathVariable String sessionId, @Valid @RequestBody PutSessionRequest request) {

        service.execute(sessionId, request);

        return ResponseEntity.status(201).body(null);

    }
}
