package com.planorama.service;

import com.planorama.controller.request.UserRequest;
import com.planorama.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostUsersService {


    public Users execute(String userId, UserRequest request) {

        return new Users(
                "1",
                userId,
                request.email(),
                request.phone(),
                request.document(),
                request.nickname(),
                request.name()
        );

    }

}
