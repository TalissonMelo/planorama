package com.planorama.controller.request;

import com.planorama.domain.Captions;
import com.planorama.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public record SessionRequest(@NotBlank String scheduleId, Captions captions, User patient, @NotBlank String title,
                             @NotNull LocalDateTime startTime,
                             @NotNull LocalDateTime endTime, String description, List<DayOfWeek> daysOfWeeks) {
}
