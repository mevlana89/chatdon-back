package com.natixis.chatdonback.controller;

import com.natixis.chatdonback.dto.CreateCandidatDto;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ "/candidats" })
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping()
    public void createCandidat(CreateCandidatDto createCandidatDto)
    {
        Candidat candidat = new Candidat();
        //MAPPER
        candidatService.createCandidat (candidat);
    }
    @GetMapping()
    public void testCreateCandidat()
    {
        Candidat candidat = new Candidat();
        candidat.setPresenceJardin(false);
        candidat.setSociableChat(false);
        candidat.setSociableChien(false);
        candidat.setTypeHebergement("test");

        //MAPPER
        candidatService.createCandidat (candidat);
    }
}
