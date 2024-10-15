package com.planorama.service;

import com.planorama.model.Legend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetLegendUserService {

    public List<Legend> execute(String userId) {

        return Arrays.asList(
                new Legend(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "#90EE90", "Sênior"),
                new Legend(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "#ADD8E6", "Pleno"),
                new Legend(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "#FFD700", "Júnior"),
                new Legend(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "#E6E6FA", "Trainee"),
                new Legend(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "#DA70D6", "Estagiário")
        );


    }
}
