package com.planorama.controller;

import com.planorama.model.Members;
import com.planorama.service.GetMemberUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetMembersUserController {

    private final GetMemberUserService service;

    @GetMapping("/members/{userId}/schedule/{scheduleId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Members> execute(@PathVariable String scheduleId, @PathVariable String userId) {

        Members memberResponses = service.execute(scheduleId, userId);

        return ResponseEntity.status(200).body(memberResponses);

    }
}
