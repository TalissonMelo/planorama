package com.planorama.controller;

import com.planorama.controller.request.ScheduleRequest;
import com.planorama.domain.Schedule;
import com.planorama.service.CreateSchedule;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CreateScheduleController {

    private final CreateSchedule service;

    @PostMapping("/schedules/users/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Schedule> execute(@RequestHeader(value = "timezone", required = true) String timezone,
                                            @PathVariable String userId,
                                            @Valid @RequestBody ScheduleRequest request) {

        Schedule response = service.execute(request, userId, timezone);

        return ResponseEntity.status(201).body(response);

    }


}