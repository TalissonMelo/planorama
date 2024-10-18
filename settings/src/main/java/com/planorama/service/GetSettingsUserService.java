package com.planorama.service;

import com.planorama.controller.request.SettingRequest;
import com.planorama.model.Settings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetSettingsUserService {

    public SettingRequest execute(String userId) {

        Settings settings = new Settings(UUID.randomUUID().toString(), userId, "en", "America/Sao_Paulo");

        return new SettingRequest(settings.getTimeZone(), settings.getLanguage());

    }
}
