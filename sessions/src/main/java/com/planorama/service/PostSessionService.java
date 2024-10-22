package com.planorama.service;

import com.planorama.controller.request.SessionRequest;
import com.planorama.domain.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostSessionService {

    public List<Session> execute(String userId, SessionRequest request, String timezone) {

        ZoneId requestZone = ZoneId.of(timezone);
        ZoneId systemZone = ZoneId.systemDefault();

        if (!request.startTime().toLocalDate().equals(request.endTime().toLocalDate())) {
            if (request.daysOfWeeks().isEmpty()) {
                throw new IllegalArgumentException("Does not create sessions");
            }
        }

        if (!request.daysOfWeeks().isEmpty()) {
            List<Session> sessions = new ArrayList<>();
            for (LocalDate data = request.startTime().toLocalDate();
                 !data.isAfter(request.endTime().toLocalDate());
                 data = data.plusDays(1)) {

                if (request.daysOfWeeks().contains(data.getDayOfWeek())) {
                    ZonedDateTime startZoned = data.atTime(request.startTime().toLocalTime())
                            .atZone(requestZone)
                            .withZoneSameInstant(systemZone);

                    ZonedDateTime finishZoned = data.atTime(request.endTime().toLocalTime())
                            .atZone(requestZone)
                            .withZoneSameInstant(systemZone);

                    Session session = Session.to(userId,
                            request.title(),
                            startZoned.toLocalDateTime(),
                            finishZoned.toLocalDateTime(),
                            request.description(),
                            request.captions(),
                            request.scheduleId(),
                            request.patient()
                    );

                    sessions.add(session);
                }
            }

            return sessions;
        }

        ZonedDateTime startZoned = request.startTime().atZone(requestZone).withZoneSameInstant(systemZone);
        ZonedDateTime finishZoned = request.endTime().atZone(requestZone).withZoneSameInstant(systemZone);

        Session session = Session.to(userId,
                request.title(),
                startZoned.toLocalDateTime(),
                finishZoned.toLocalDateTime(),
                request.description(),
                request.captions(),
                request.scheduleId(),
                request.patient()
        );

        return Arrays.asList(session);
    }
}
