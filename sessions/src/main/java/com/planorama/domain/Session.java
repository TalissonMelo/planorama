package com.planorama.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Session  {


    private String id;

    private String scheduleId;

    private String ownerId;

    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String description;

    private Captions caption;

    private User patient;



    private Session(String ownerId, String title, LocalDateTime startTime, LocalDateTime endTime, String description, Captions caption, String scheduleId, User patient) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.caption = caption;
        this.scheduleId = scheduleId;
        this.patient = patient;
        this.ownerId = ownerId;
    }

    public static Session to(String ownerId, String title, LocalDateTime startTime, LocalDateTime endTime, String description, Captions caption, String scheduleId, User patient) {
        return new Session(ownerId, title, startTime, endTime, description, caption, scheduleId, patient);
    }

    public Session update(String description) {
        this.description = description;
        return this;
    }
}
