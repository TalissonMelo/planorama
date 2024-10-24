package com.planorama.service;

import com.planorama.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUsersService {

    public Users execute(String userId) {

        return new Users(
                "1",
                userId,
                "talisson@planorama.com",
                "+55 11 99999-9999",
                "123.456.789-00",
                "Talisson Mello",
                "Talisson De Melo Rodrigues"
        );
    }

}
