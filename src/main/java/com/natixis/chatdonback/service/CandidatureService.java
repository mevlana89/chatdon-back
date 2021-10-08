package com.natixis.chatdonback.service;

import com.natixis.chatdonback.entity.Candidature;
import com.natixis.chatdonback.repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatureService {
    @Autowired
    private CandidatureRepository candidatureRepository;


    public List<Candidature> findAllCandidaturesByCandidatId (Long candidatId) throws Exception{
        List<Candidature> myCandidatures = candidatureRepository.findCandidaturesByCandidat_Id(candidatId);
        if (myCandidatures.size()!=0) {
            return myCandidatures;
        }
        throw new Exception("No Candidatures to return");

    }

    public List<Candidature> findAllCandidaturesByCat (Integer chatId) throws Exception{
        List<Candidature> myCandidatures = candidatureRepository.findCandidaturesByChat_Id(chatId);
        if (myCandidatures.size()!=0) {
            return myCandidatures;
        }
        throw new Exception("No Candidatures to return");
    }


}
