package com.planorama.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetTime;

public record ScheduleRequest(@NotBlank String name, @NotNull OffsetTime startTime, @NotNull OffsetTime endTime) {
}
