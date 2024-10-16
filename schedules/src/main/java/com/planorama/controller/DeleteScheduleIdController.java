package com.planorama.controller;

import com.planorama.service.DeleteScheduleIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteScheduleIdController {

    private final DeleteScheduleIdService service;

    @CrossOrigin(origins = "*")
    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> execute(@PathVariable String scheduleId) {

        service.execute(scheduleId);

        return ResponseEntity.noContent().build();

    }
}
