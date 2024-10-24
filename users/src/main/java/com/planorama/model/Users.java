package com.planorama.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private String id;

    private String userId;

    private String email;

    private String phone;

    private String document;

    private String nickname;

    private  String name;
}
