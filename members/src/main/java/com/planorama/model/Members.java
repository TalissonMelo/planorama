package com.planorama.model;

import com.planorama.model.enums.MemberType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Members {

    private String id;
    private String ownerId;
    private String userId;
    private Schedule schedule;
    private String email;
    private MemberType memberType;
    private Boolean active;
    private Boolean accept;

}
