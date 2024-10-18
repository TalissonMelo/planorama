package com.planorama.service;

import com.planorama.controller.request.ScheduleResponse;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class GetSchedule {

    public List<ScheduleResponse> execute(String userId, String timezone) {
        List<ScheduleResponse> schedules = new ArrayList<>();

        ZoneId zoneId = ZoneId.of(timezone);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (int i = 0; i < 5; i++) {
            ZonedDateTime startTime = ZonedDateTime.now(zoneId).plusHours(i);
            ZonedDateTime endTime = startTime.plusHours(i);


            String formattedStartTime = startTime.format(timeFormatter);
            String formattedEndTime = endTime.format(timeFormatter);

            ScheduleResponse schedule = new ScheduleResponse(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    "Talisson De Melo Rodrigues",
                    formattedStartTime,
                    formattedEndTime
            );

            schedules.add(schedule);
        }

        return schedules;
    }
}
