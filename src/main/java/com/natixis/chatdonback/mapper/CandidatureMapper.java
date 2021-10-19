package com.natixis.chatdonback.mapper;

import com.natixis.chatdonback.dto.CreateCandidatureDto;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.entity.Candidature;
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

        return null;
    }
}
