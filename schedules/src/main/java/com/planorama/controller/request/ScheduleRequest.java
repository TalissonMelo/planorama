package com.planorama.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record ScheduleRequest(@NotBlank String name, @NotNull Timestamp startTime, @NotNull Timestamp endTime) {
}
