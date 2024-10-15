package com.planorama.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Legend {

    private String id;

    private String ownerId;

    private String color;

    private String description;


    public Legend update(String color, String description) {
        this.color = color;
        this.description = description;
        return this;
    }
}
