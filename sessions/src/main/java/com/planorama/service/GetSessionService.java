package com.planorama.service;

import com.planorama.controller.response.SessionResponse;
import com.planorama.domain.Captions;
import com.planorama.domain.Session;
import com.planorama.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class GetSessionService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;


    public List<SessionResponse> execute(String scheduleId, int month, int year, String timezone) {

        List<SessionResponse> sessions = new ArrayList<>();
        ZoneId targetZone = ZoneId.of(timezone);
        ZoneId systemZone = ZoneId.systemDefault();

        sessions.add(createSession(
                "Consulta Inicial", LocalDate.of(year, month, 26), 7, 0, 9, 0,
                "Primeira consulta para entender o histórico do paciente e traçar o plano de tratamento.",
                "#FFDAB9", "Avaliação Inicial", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Sessão de Acompanhamento", LocalDate.of(year, month, 29), 10, 0, 11, 0,
                "Revisão de progresso e ajustes no tratamento ou terapia.",
                "#FF6347", "Acompanhamento Regular", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Treinamento Cognitivo", LocalDate.of(year, month, 28), 11, 0, 12, 0,
                "Exercícios para estimular a memória e concentração.",
                "#20B2AA", "Estimulação Cognitiva", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Sessão Terapêutica - Ansiedade", LocalDate.of(year, month, 27), 13, 0, 14, 0,
                "Técnicas para gerenciar ansiedade e estresse.",
                "#DA70D6", "Terapia de Ansiedade", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Consulta Nutricional", LocalDate.of(year, month, 23), 14, 0, 15, 0,
                "Discussão sobre hábitos alimentares saudáveis e plano alimentar personalizado.",
                "#FFFFE0", "Nutrição e Bem-Estar", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Atendimento Fisioterapêutico", LocalDate.of(year, month, 22), 18, 0, 19, 0,
                "Exercícios específicos para recuperação física.",
                "#FF6347", "Reabilitação Física", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Terapia Ocupacional", LocalDate.of(year, month, 18), 19, 0, 20, 0,
                "Desenvolvimento de habilidades para atividades do dia a dia.",
                "#00FFFF", "Habilidades Funcionais", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Sessão de Mindfulness", LocalDate.of(year, month, 15), 20, 0, 21, 0,
                "Práticas de atenção plena para melhorar o bem-estar emocional.",
                "#FFB6C1", "Meditação Guiada", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Avaliação Final", LocalDate.of(year, month, 9), 21, 0, 22, 0,
                "Revisão dos resultados alcançados e próximos passos.",
                "#E6E6FA", "Conclusão do Tratamento", scheduleId, targetZone, systemZone));

        sessions.add(createSession(
                "Sessão de Encerramento", LocalDate.of(year, month, 7), 22, 0, 23, 0,
                "Reflexão sobre o processo e encerramento formal do acompanhamento.",
                "#ADD8E6", "Encerramento e Reflexão", scheduleId, targetZone, systemZone));

        return sessions;

    }

    private SessionResponse createSession(
            String title, LocalDate date, int startHour, int startMinute, int endHour, int endMinute,
            String description, String color, String captionDesc, String scheduleId,
            ZoneId targetZone, ZoneId systemZone) {

        LocalDateTime startLocal = LocalDateTime.of(date, LocalTime.of(startHour, startMinute));
        LocalDateTime endLocal = LocalDateTime.of(date, LocalTime.of(endHour, endMinute));

        ZonedDateTime startZoned = startLocal.atZone(systemZone).withZoneSameInstant(targetZone);
        ZonedDateTime endZoned = endLocal.atZone(systemZone).withZoneSameInstant(targetZone);

        String formattedStartTime = startZoned.format(FORMATTER);
        String formattedEndTime = endZoned.format(FORMATTER);

        return new SessionResponse(UUID.randomUUID().toString(),
                scheduleId,
                UUID.randomUUID().toString(),
                title,
                formattedStartTime,
                formattedEndTime,
                description,
                new Captions("1", color, captionDesc),
                new User("123", "John Doe", "")
        );
    }


}