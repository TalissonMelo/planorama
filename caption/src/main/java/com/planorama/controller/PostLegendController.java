package com.planorama.controller;

import com.planorama.controller.request.LegendRequest;
import com.planorama.model.Legend;
import com.planorama.service.PostLegendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostLegendController {

    private final PostLegendService service;

    @PostMapping("/captions")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Legend> execute(@Valid @RequestBody LegendRequest request) {

        Legend response = service.execute(request);

        return ResponseEntity.status(201).body(response);

    }
}
