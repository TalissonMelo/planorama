package com.planorama.service;

import com.planorama.controller.request.MemberUserRequest;
import com.planorama.model.Members;
import com.planorama.model.enums.MemberType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostMemberService {

    public Members execute(MemberUserRequest request) {

        Members members = toMembers(request);

        return members;
    }

    private Members toMembers(MemberUserRequest request) {

        Members member1 = new Members();
        member1.setId(UUID.randomUUID().toString());
        member1.setOwnerId(request.ownerId());
        member1.setSchedule(request.schedule());
        member1.setMemberType(MemberType.VIEWER);
        member1.setAccept(false);
        member1.setActive(true);

        //Enviar Email
        //Listar Usuário por email verificar se existe salvar idUsuário
        member1.setUserId(UUID.randomUUID().toString());
        member1.setEmail(request.email());

        return member1;
    }

}
