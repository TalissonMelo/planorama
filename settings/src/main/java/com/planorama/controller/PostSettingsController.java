package com.planorama.controller;

import com.planorama.controller.request.SettingRequest;
import com.planorama.service.PostLegendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostSettingsController {

    private final PostLegendService service;

    @PostMapping("/settings/users/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<SettingRequest> execute(@PathVariable String userId,
                                                  @Valid @RequestBody SettingRequest request) {

        SettingRequest response = service.execute(userId, request);

        return ResponseEntity.status(201).body(response);

    }
}
