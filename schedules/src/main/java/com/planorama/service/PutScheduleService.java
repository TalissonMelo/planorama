package com.planorama.service;

import com.planorama.controller.request.ScheduleRequest;
import com.planorama.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PutScheduleService {

    public Schedule execute(String scheduleId, ScheduleRequest request) {

        return new Schedule(scheduleId,
                request.name(),
                request.userId(),
                request.startTime(),
                request.endTime());
    }

}
