package com.liberbox.schedule.controller;

import com.liberbox.schedule.controller.response.ScheduleResponse;
import com.liberbox.schedule.service.GetScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "schedule")
@RestController
@RequiredArgsConstructor
public class GetScheduleController {

    private final GetScheduleService service;

    @GetMapping("/v1/schedule")
    public ResponseEntity<List<ScheduleResponse>> execute() {

        List<ScheduleResponse> response = service.execute();

        return ResponseEntity.status(200).body(response);

    }
}
