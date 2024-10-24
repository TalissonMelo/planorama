package com.planorama.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(@Email(message = "Email is mandatory") String email,
                          @NotBlank(message = "Nickname is mandatory") String nickname,
                          @NotBlank(message = "Name is mandatory") String name,
                          String phone,
                          String document) {

}
