package com.natixis.chatdonback.service;

import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    public void createCandidat(Candidat candidat)
    {
        candidatRepository.save(candidat);
    }
}
