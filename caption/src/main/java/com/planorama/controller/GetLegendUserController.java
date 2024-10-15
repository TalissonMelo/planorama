package com.planorama.controller;


import com.planorama.model.Legend;
import com.planorama.service.GetLegendUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetLegendUserController {

    private final GetLegendUserService service;

    @GetMapping("/v1/users/{userId}/legends")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Legend>> execute(@PathVariable String userId) {

        List<Legend> response = service.execute(userId);

        return ResponseEntity.status(200).body(response);

    }
}
