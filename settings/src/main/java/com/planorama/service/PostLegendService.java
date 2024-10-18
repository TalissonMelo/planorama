package com.planorama.service;

import com.planorama.controller.request.SettingRequest;
import com.planorama.model.Settings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostLegendService {


    public SettingRequest execute(String userId, SettingRequest request) {

        Settings settings = new Settings(UUID.randomUUID().toString(),
                userId,
                request.language(),
                request.timeZone());


        return new SettingRequest(settings.getTimeZone(), settings.getLanguage());
    }


}
