package com.planorama.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record ScheduleRequest(@NotBlank String userId, @NotBlank String name, @NotNull LocalTime startTime,
                              @NotNull LocalTime endTime) {
}
