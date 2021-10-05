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


    public Candidature findAllCandidaturesByCandidat (Integer candidatId) throws Exception{
        Optional<Candidature> myCandidatures = candidatureRepository.findById(Long.valueOf(candidatId));
        if (myCandidatures.isPresent()) {
            return myCandidatures.get();
        }
        throw new Exception("No Candidatures to return");
    }

    public Candidature findAllCandidaturesByCat (Integer chatId) throws Exception{
        Optional<Candidature> myCandidatures = candidatureRepository.findById(Long.valueOf(chatId));
        if (myCandidatures.isPresent()) {
            return myCandidatures.get();
        }
        throw new Exception("No Candidatures to return");
    }


}
