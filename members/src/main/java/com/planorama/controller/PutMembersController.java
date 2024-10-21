package com.planorama.controller;

import com.planorama.controller.request.MemberUserAcceptRequest;
import com.planorama.controller.request.MemberUserRequest;
import com.planorama.model.Members;
import com.planorama.service.PostMemberService;
import com.planorama.service.PutMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PutMembersController {

    private final PutMemberService service;

    @PutMapping("/members/{memberId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> execute(@Valid @RequestBody MemberUserAcceptRequest request) {

        service.execute(request);

        return ResponseEntity.status(200).body(null);

    }
}
