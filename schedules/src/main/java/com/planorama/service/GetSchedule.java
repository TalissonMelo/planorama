package com.planorama.service;

import com.planorama.domain.Schedule;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GetSchedule {

    public List<Schedule> execute() {
        List<Schedule> schedules = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            OffsetTime startTime = OffsetTime.of(9 + i, 30, 0, 0, ZoneOffset.of("-03:00"));
            OffsetTime endTime = startTime.plusHours(2 + i);

            Schedule schedule = new Schedule(UUID.randomUUID().toString(),
                    "Melo",
                    startTime,
                    endTime);

            schedules.add(schedule);
        }

        return schedules;
    }
}
