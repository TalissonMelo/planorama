package com.planorama.controller;

import com.planorama.controller.request.MemberUserRequest;
import com.planorama.model.Members;
import com.planorama.service.PostMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;

@RestController
@RequiredArgsConstructor
public class PostMembersController {

    private final PostMemberService service;

    @PostMapping("/members/schedules")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Members> execute(@Valid @RequestBody MemberUserRequest request) {

        Members member = service.execute(request);

        return ResponseEntity.status(201).body(member);

    }
}
