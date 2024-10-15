package com.planorama.service;

import com.planorama.controller.request.LegendRequest;
import com.planorama.model.Legend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PutLegendService {

    public Legend execute(String legendId, LegendRequest request) {

        return new Legend(legendId,
                request.userId(),
                request.color(),
                request.description());

    }
}
