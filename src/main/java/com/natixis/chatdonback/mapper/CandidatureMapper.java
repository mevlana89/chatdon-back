package com.natixis.chatdonback.mapper;

import com.natixis.chatdonback.dto.CreateCandidatureDto;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.entity.Candidature;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatureMapper {
    public Candidature createCandidatureDtoToEntity(CreateCandidatureDto createCandidatureDto){
        if (createCandidatureDto == null) {
            return null;
        }
        System.out.println("mapper condidature - dto to entity ");
        Candidature candidature = new Candidature();
        candidature.setChat(createCandidatureDto.getChat());
        candidature.setStatus(createCandidatureDto.getStatus());
        candidature.setCandidat(createCandidatureDto.getCandidat());

        return candidature;
    }
}
