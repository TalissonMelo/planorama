package com.planorama.controller;

import com.planorama.model.Members;
import com.planorama.service.GetMemberUserScheduleService;
import com.planorama.service.GetMemberUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetMembersUserScheduleController {

    private final GetMemberUserScheduleService service;

    @GetMapping("/members/{userId}/schedule")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Members>> execute(@PathVariable String userId) {

        List<Members> memberResponses = service.execute(userId);

        return ResponseEntity.status(200).body(memberResponses);

    }
}
