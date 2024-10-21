package com.planorama.controller;

import com.planorama.controller.request.MemberUserAcceptRequest;
import com.planorama.controller.request.MemberUserTypeRequest;
import com.planorama.service.PutMemberService;
import com.planorama.service.PutMemberTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PutMemberTypeController {

    private final PutMemberTypeService service;

    @PutMapping("/members/{memberId}/type")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> execute(@Valid @RequestBody MemberUserTypeRequest request) {

        service.execute(request);

        return ResponseEntity.status(200).body(null);

    }
}
