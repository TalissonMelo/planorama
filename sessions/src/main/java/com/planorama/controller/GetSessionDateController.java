package com.planorama.controller;


import com.planorama.controller.response.SessionResponse;
import com.planorama.service.GetSessionDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetSessionDateController {

    private final GetSessionDateService service;

    @CrossOrigin(origins = "*")
    @GetMapping("session/schedule/{scheduleId}")
    public ResponseEntity<List<SessionResponse>> execute(@PathVariable String scheduleId,
                                                         @RequestHeader(value = "timezone", required = true) String timezone,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        List<SessionResponse> response = service.execute(scheduleId, date, timezone);

        return ResponseEntity.status(200).body(response);

    }
}
