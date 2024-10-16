package com.planorama.controller;

import com.planorama.controller.request.ScheduleRequest;
import com.planorama.domain.Schedule;
import com.planorama.service.PutScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PutScheduleController {

    private final PutScheduleService service;

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<Schedule> execute(@PathVariable String scheduleId,
                                            @Valid @RequestBody ScheduleRequest request) {

        Schedule response = service.execute(scheduleId, request);

        return ResponseEntity.status(200).body(response);

    }
}
