package com.planorama.controller;


import com.planorama.service.DeleteLegendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteLegendController {

    private final DeleteLegendService service;

    @DeleteMapping("/captions/{captionId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> execute(@PathVariable String captionId) {

        service.execute(captionId);

        return ResponseEntity.noContent().build();

    }
}
