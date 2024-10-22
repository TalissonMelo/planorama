package com.planorama.controller.request;

import jakarta.validation.constraints.NotBlank;

public record PutSessionRequest(@NotBlank String description) {
}
