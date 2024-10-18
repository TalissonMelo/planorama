package com.planorama.service;

import com.planorama.controller.request.ScheduleRequest;
import com.planorama.domain.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class CreateSchedule {

    public Schedule execute(ScheduleRequest request, String userId, String timezone) {

        ZoneId zoneId = ZoneId.of(timezone);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate today = LocalDate.now(zoneId);

        ZonedDateTime startTimeInZone = today.atTime(request.startTime()).atZone(zoneId);
        ZonedDateTime endTimeInZone = today.atTime(request.endTime()).atZone(zoneId);

        String formattedStartTime = startTimeInZone.format(timeFormatter);
        String formattedEndTime = endTimeInZone.format(timeFormatter);

        return new Schedule(UUID.randomUUID().toString(),
                request.name(),
                userId,
                formattedStartTime,
                formattedEndTime);
    }
}
