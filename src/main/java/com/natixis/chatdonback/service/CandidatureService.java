package com.natixis.chatdonback.service;

import com.natixis.chatdonback.repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatureService {
    @Autowired
    private CandidatureRepository candidatureRepository;


}
