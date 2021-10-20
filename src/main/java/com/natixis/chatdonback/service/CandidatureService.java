package com.natixis.chatdonback.service;

import com.natixis.chatdonback.dto.CreateCandidatureDto;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.entity.Candidature;
import com.natixis.chatdonback.mapper.CandidatureMapper;
import com.natixis.chatdonback.repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidatureService {
    @Autowired
    private CandidatureRepository candidatureRepository;

    @Autowired
    private CandidatureMapper candidatureMapper;


    public List<Candidature> findAllCandidaturesByCandidatId (Long candidatId) {
        List<Candidature> myCandidatures = candidatureRepository.findCandidaturesByCandidat_Id(candidatId);
            return myCandidatures;
    }

    public List<Candidature> findAllCandidaturesByCat (Integer chatId) throws Exception{
        List<Candidature> myCandidatures = candidatureRepository.findCandidaturesByChat_Id(chatId);
        if (myCandidatures.size()!=0) {
            return myCandidatures;
        }
        throw new Exception("No Candidatures to return");
    }

    public void createCandidature(CreateCandidatureDto createCandidatureDto){
        Candidature candidature=candidatureMapper.createCandidatureDtoToEntity(createCandidatureDto);
        candidatureRepository.save(candidature);
    }

    public void deleteCandidatureById(Integer id){
        candidatureRepository.deleteById(id);
    }




}
