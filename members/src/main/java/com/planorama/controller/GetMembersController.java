package com.planorama.controller;

import com.planorama.model.Members;
import com.planorama.service.GetMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetMembersController {

    private final GetMemberService service;

    @GetMapping("/members/schedule/{scheduleId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Members>> execute(@PathVariable String scheduleId) {

        List<Members> memberResponses = service.execute(scheduleId);

        return ResponseEntity.status(200).body(memberResponses);

    }
}
