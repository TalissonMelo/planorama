package com.planorama.controller;

import com.planorama.controller.request.ScheduleRequest;
import com.planorama.controller.request.ScheduleResponse;
import com.planorama.service.PutScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PutScheduleController {

    private final PutScheduleService service;

    @PutMapping("/schedules/{scheduleId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ScheduleResponse> execute(@RequestHeader(value = "timezone", required = true) String timezone,
                                                    @PathVariable String scheduleId,
                                                    @Valid @RequestBody ScheduleRequest request) {

        ScheduleResponse response = service.execute(scheduleId, request, timezone);

        return ResponseEntity.status(200).body(response);

    }
}
