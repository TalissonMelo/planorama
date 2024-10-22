package com.planorama.controller;


import com.planorama.controller.response.SessionResponse;
import com.planorama.service.GetSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetSessionController {

    private final GetSessionService service;

    @CrossOrigin(origins = "*")
    @GetMapping("/sessions/schedule/{scheduleId}")
    public ResponseEntity<List<SessionResponse>> execute(@PathVariable String scheduleId,
                                                 @RequestParam(required = true) int month,
                                                 @RequestParam(required = true) int year,
                                                 @RequestHeader(value = "timezone", required = true) String timezone) {

        List<SessionResponse> response = service.execute(scheduleId, month, year, timezone);

        return ResponseEntity.status(200).body(response);

    }
}
