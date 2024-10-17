package com.planorama.service;

import com.planorama.controller.request.LegendRequest;
import com.planorama.model.Legend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostLegendService {


    public Legend execute(LegendRequest request, String userId) {

        return new Legend(UUID.randomUUID().toString(),
                userId,
                request.color(),
                request.description());
    }


}
