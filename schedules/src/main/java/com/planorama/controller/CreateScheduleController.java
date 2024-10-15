package com.planorama.controller;

import com.planorama.controller.request.ScheduleRequest;
import com.planorama.domain.Schedule;
import com.planorama.service.CreateSchedule;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateScheduleController {

    private final CreateSchedule service;

    @PostMapping("/v1/schedule")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Schedule> execute(@Valid @RequestBody ScheduleRequest request) {

        Schedule response = service.execute(request);

        return ResponseEntity.status(201).body(response);

    }
}