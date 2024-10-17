package com.planorama.controller;

import com.planorama.controller.request.LegendRequest;
import com.planorama.model.Legend;
import com.planorama.service.PostLegendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostLegendController {

    private final PostLegendService service;

    @PostMapping("/captions/users/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Legend> execute(@PathVariable String userId,
                                          @Valid @RequestBody LegendRequest request) {

        Legend response = service.execute(request, userId);

        return ResponseEntity.status(201).body(response);

    }
}
