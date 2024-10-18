package com.planorama.controller;


import com.planorama.controller.request.SettingRequest;
import com.planorama.service.GetSettingsUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetSettingsUserController {

    private final GetSettingsUserService service;

    @GetMapping("/settings/users/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<SettingRequest> execute(@PathVariable String userId) {

        SettingRequest response = service.execute(userId);

        return ResponseEntity.status(200).body(response);

    }
}
