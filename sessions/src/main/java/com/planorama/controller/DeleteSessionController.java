package com.planorama.controller;


import com.planorama.service.DeleteSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteSessionController {

    private final DeleteSessionService service;

    @CrossOrigin(origins = "*")
    @DeleteMapping("/sessions/{sessionId}")
    public ResponseEntity<Void> execute(@PathVariable String sessionId) {

        service.execute(sessionId);

        return ResponseEntity.noContent().build();

    }
}
