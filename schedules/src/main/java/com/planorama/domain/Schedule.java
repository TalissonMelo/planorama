package com.planorama.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    private String id;

    private String name;

    private OffsetTime startTime;

    private OffsetTime endTime;
}
