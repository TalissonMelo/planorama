package com.planorama.controller;

import com.planorama.service.DeleteMemberIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteMemberIdController {

    private final DeleteMemberIdService service;

    @DeleteMapping("/members/{memberId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> execute(@PathVariable String memberId) {

        service.execute(memberId);

        return ResponseEntity.noContent().build();

    }
}
