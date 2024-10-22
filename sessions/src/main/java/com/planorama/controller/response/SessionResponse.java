package com.planorama.controller.response;

import com.planorama.domain.Captions;
import com.planorama.domain.User;

import java.time.LocalDateTime;

public record SessionResponse(String id,
                              String scheduleId,
                              String ownerId,
                              String title,
                              String startTime,
                              String endTime,
                              String description,
                              Captions caption,
                              User patient) {
}

