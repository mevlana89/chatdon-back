package com.natixis.chatdonback.mapper;

import com.natixis.chatdonback.dto.CreateCandidatureDto;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.entity.Candidature;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CandidatureMapper {
    public Candidature createCandidatureDtoToEntity(CreateCandidatureDto createCandidatureDto){
        if (createCandidatureDto == null) {
            return null;
        }
        System.out.println("mapper candidature - dto to entity ");
        Candidature candidature = new Candidature();
        candidature.setChat(createCandidatureDto.getChat());
        candidature.setStatus(createCandidatureDto.getStatus());
        candidature.setCandidat(createCandidatureDto.getCandidat());
        System.out.println("id_chat "+candidature.getChat().getId());
        return candidature;
    }

    public CreateCandidatureDto createEntityToDto(Candidature candidature) {
        CreateCandidatureDto candidatureDto = new CreateCandidatureDto();
        candidatureDto.setId(candidature.getId());
        candidatureDto.setChat(candidature.getChat());
        candidatureDto.setStatus(candidature.getStatus());
        Candidat candidat = new Candidat();
        candidat.setId(candidature.getCandidat().getId());
        candidatureDto.setCandidat(candidat);
        System.out.println("id_chat "+candidature.getChat().getId());
        return candidatureDto;
    }
}
