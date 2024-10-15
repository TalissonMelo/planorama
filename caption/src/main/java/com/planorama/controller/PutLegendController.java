package com.planorama.controller;

import com.planorama.controller.request.LegendRequest;
import com.planorama.model.Legend;
import com.planorama.service.PutLegendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PutLegendController {

    private final PutLegendService service;

    @PutMapping("/v1/legends/{legendId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Legend> execute(@PathVariable String legendId,
                                          @Valid @RequestBody LegendRequest request) {

        Legend response = service.execute(legendId, request);

        return ResponseEntity.status(200).body(response);

    }
}
