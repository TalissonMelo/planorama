package com.planorama.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    private String id;

    private String name;

    private String userId;

    private String startTime;

    private String endTime;
}
