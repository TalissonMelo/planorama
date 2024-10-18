package com.planorama.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settings {

    private String id;

    private String userId;

    private String language;

    private String timeZone;
}
