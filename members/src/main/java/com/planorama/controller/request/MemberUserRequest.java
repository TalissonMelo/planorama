package com.planorama.controller.request;

import com.planorama.model.Schedule;
import com.planorama.model.enums.MemberType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MemberUserRequest(@NotBlank(message = "Owner is mandatory")  String ownerId,
                                Schedule schedule,
                                @Email String email,
                                @NotNull MemberType memberType) {
}
