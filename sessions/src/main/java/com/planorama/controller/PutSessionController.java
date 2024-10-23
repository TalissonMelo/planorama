package com.planorama.controller;

import com.planorama.controller.request.PutSessionRequest;
import com.planorama.service.PutSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PutSessionController {

    private final PutSessionService service;

    @CrossOrigin(origins = "*")
    @PutMapping("/sessions/{sessionId}")
    public ResponseEntity<Void> execute(@PathVariable String sessionId, @Valid @RequestBody PutSessionRequest request) {

        service.execute(sessionId, request);

        return ResponseEntity.status(201).body(null);

    }
}
