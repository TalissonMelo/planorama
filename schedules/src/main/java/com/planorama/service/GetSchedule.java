package com.planorama.service;

import com.planorama.domain.Schedule;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GetSchedule {

    public List<Schedule> execute() {
        List<Schedule> schedules = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Timestamp startTime = new Timestamp(System.currentTimeMillis() + (i * 3600000));
            Timestamp endTime = new Timestamp(startTime.getTime() + 3600000);

            Schedule schedule = new Schedule(UUID.randomUUID().toString(),
                    "Melo",
                    startTime,
                    endTime);

            schedules.add(schedule);
        }

        return schedules;
    }
}
