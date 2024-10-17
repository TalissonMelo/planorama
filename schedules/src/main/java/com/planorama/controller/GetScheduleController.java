package com.planorama.controller;

import com.planorama.domain.Schedule;
import com.planorama.service.GetSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetScheduleController {

    private final GetSchedule service;

    @GetMapping("/schedules/users/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Schedule>> execute(@PathVariable String userId) {

        List<Schedule> response = service.execute(userId);

        return ResponseEntity.status(200).body(response);

    }
}
