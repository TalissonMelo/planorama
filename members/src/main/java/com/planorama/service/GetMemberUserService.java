package com.planorama.service;

import com.planorama.model.Members;
import com.planorama.model.Schedule;
import com.planorama.model.enums.MemberType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMemberUserService {


    public Members execute(String scheduleId, String memberId) {

        Members member1 = new Members();
        member1.setId(UUID.randomUUID().toString());
        member1.setOwnerId(UUID.randomUUID().toString());
        member1.setUserId(memberId);
        member1.setEmail("talisson@planorama.com");
        member1.setSchedule(new Schedule(scheduleId, "AWS"));
        member1.setMemberType(MemberType.EDITOR);
        member1.setAccept(false);
        member1.setActive(true);

        return member1;

    }
}
