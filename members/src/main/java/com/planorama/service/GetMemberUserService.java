package com.planorama.service;

import com.planorama.model.Members;
import com.planorama.model.Schedule;
import com.planorama.model.User;
import com.planorama.model.enums.MemberType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMemberUserService {


    public Members execute(String scheduleId, String memberId) {


        //Retornar apenas registros accept = true

        Members member1 = new Members();
        member1.setId(UUID.randomUUID().toString());
        member1.setOwnerId(UUID.randomUUID().toString());
        member1.setUser(new User(memberId, "user_002", "user2@example.com"));
        member1.setEmail("talisson@planorama.com");
        member1.setSchedule(new Schedule(scheduleId, "AWS"));
        member1.setMemberType(MemberType.EDITOR);
        member1.setAccept(false);
        member1.setActive(true);

        return member1;

    }
}
