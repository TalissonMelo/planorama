package com.planorama.controller.request;

import com.planorama.model.Schedule;
import com.planorama.model.enums.MemberType;

public record MemberUserRequest(String ownerId,
                                Schedule schedule,
                                String email,
                                MemberType memberType,
                                Boolean accept) {
}
