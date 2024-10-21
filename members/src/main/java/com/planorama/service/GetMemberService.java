package com.planorama.service;

import com.planorama.model.Members;
import com.planorama.model.Schedule;
import com.planorama.model.User;
import com.planorama.model.enums.MemberType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetMemberService {
    public List<Members> execute(String scheduleId) {
        List<Members> membersList = new ArrayList<>();

        Members member1 = new Members();
        member1.setId("1");
        member1.setOwnerId(UUID.randomUUID().toString());
        member1.setUser(new User(UUID.randomUUID().toString(), "user_001", "user1@example.com"));
        member1.setEmail("user1@example.com");
        member1.setSchedule(new Schedule(scheduleId, "Morning Yoga"));
        member1.setMemberType(MemberType.VIEWER);
        member1.setActive(true);
        member1.setAccept(false);

        Members member2 = new Members();
        member2.setId("2");
        member2.setOwnerId(UUID.randomUUID().toString());
        member2.setUser(new User(UUID.randomUUID().toString(), "user_002", "user2@example.com"));
        member2.setEmail("user2@example.com");
        member2.setSchedule(new Schedule(scheduleId, "Evening Pilates"));
        member2.setMemberType(MemberType.VIEWER);
        member2.setActive(true);
        member2.setAccept(false);


        membersList.add(member1);
        membersList.add(member2);

        return membersList;
    }
}
