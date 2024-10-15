package com.planorama.service;

import com.planorama.controller.request.ScheduleRequest;
import com.planorama.domain.Schedule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateSchedule {

    public Schedule execute(ScheduleRequest scheduleRequest) {

        return new Schedule(UUID.randomUUID().toString(),
                scheduleRequest.name(),
                scheduleRequest.startTime(),
                scheduleRequest.endTime());
    }
}
