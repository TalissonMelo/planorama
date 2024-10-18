package com.planorama.controller.request;

import jakarta.validation.constraints.NotBlank;

public record SettingRequest(@NotBlank(message = "TimeZone is mandatory") String timeZone,
                             @NotBlank(message = "Language is mandatory") String language) {
}
