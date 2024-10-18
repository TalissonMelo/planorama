package com.planorama.controller;

import com.planorama.controller.request.ScheduleResponse;
import com.planorama.service.GetSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetScheduleController {

    private final GetSchedule service;

    @GetMapping("/schedules/users/{userId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ScheduleResponse>> execute(@RequestHeader(value = "timezone", required = true) String timezone,
                                                          @PathVariable String userId) {

        List<ScheduleResponse> response = service.execute(userId, timezone);

        return ResponseEntity.status(200).body(response);

    }
}
