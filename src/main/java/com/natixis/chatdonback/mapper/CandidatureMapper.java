package com.natixis.chatdonback.mapper;

import com.natixis.chatdonback.dto.CreateCandidatureDto;
import com.natixis.chatdonback.dto.GetCandidatureDto;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.entity.Candidature;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CandidatureMapper {

    @Autowired
    CandidatMapper candidatMapper;

    public Candidature createCandidatureDtoToEntity(CreateCandidatureDto createCandidatureDto){
        if (createCandidatureDto == null) {
            return null;
        }
        System.out.println("mapper candidature - dto to entity ");
        Candidature candidature = new Candidature();
        candidature.setChat(createCandidatureDto.getChat());
        candidature.setStatus(createCandidatureDto.getStatus());
        candidature.setCandidat(candidatMapper.getCandidatDtoToEntity(createCandidatureDto.getCandidat()));
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
        candidatureDto.setCandidat(candidatMapper.candidatEntityToGetDto(candidat));
        System.out.println("id_chat "+candidature.getChat().getId());
        return candidatureDto;
    }

    public Candidature getCandidatureDtoToEntity(GetCandidatureDto getCandidatureDto) {
        Candidature candidature = new Candidature();
        candidature.setId(getCandidatureDto.getId());
        candidature.setCandidat(candidatMapper.getCandidatDtoToEntity(getCandidatureDto.getCandidat()));
        candidature.setChat(getCandidatureDto.getChat());
        candidature.setStatus(getCandidatureDto.getStatus());
        return candidature;
    }
}
