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

    @PutMapping("/captions/{captionId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Legend> execute(@PathVariable String captionId,
                                          @Valid @RequestBody LegendRequest request) {

        Legend response = service.execute(captionId, request);

        return ResponseEntity.status(200).body(response);

    }
}
