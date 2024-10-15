package com.planorama.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    private String id;

    private String name;

    private Timestamp startTime;

    private Timestamp endTime;
}
