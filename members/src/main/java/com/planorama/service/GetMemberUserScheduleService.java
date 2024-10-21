package com.planorama.service;

import com.planorama.model.Members;
import com.planorama.model.Schedule;
import com.planorama.model.User;
import com.planorama.model.enums.MemberType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMemberUserScheduleService {


    public List<Members> execute(String memberId) {

        Members member1 = new Members();
        member1.setId(UUID.randomUUID().toString());
        member1.setOwnerId(UUID.randomUUID().toString());
        member1.setUser(new User(UUID.randomUUID().toString(), "user_002", "user2@example.com"));
        member1.setEmail("talisson@planorama.com");
        member1.setSchedule(new Schedule(UUID.randomUUID().toString(), "AWS"));
        member1.setMemberType(MemberType.VIEWER);
        member1.setActive(true);
        member1.setAccept(false);

        Members member2 = new Members();
        member2.setId(UUID.randomUUID().toString());
        member2.setOwnerId(UUID.randomUUID().toString());
        member2.setUser(new User(UUID.randomUUID().toString(), "user_002", "user2@example.com"));
        member2.setEmail("talisson@planorama.com");
        member2.setSchedule(new Schedule(UUID.randomUUID().toString(), "Evening Pilates"));
        member2.setMemberType(MemberType.VIEWER);
        member2.setActive(true);
        member2.setAccept(false);

        return Arrays.asList(member1, member2);

    }
}
