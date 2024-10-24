package com.planorama.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
@JsonInclude(value = Include.NON_NULL)
public class Details {

    String title;
    Integer status;
    String developerMessage;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime time;
    List<Name> errors;
}
