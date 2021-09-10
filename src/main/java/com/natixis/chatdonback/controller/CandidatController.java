package com.natixis.chatdonback.controller;

import com.natixis.chatdonback.dto.CreateCandidatDto;
import com.natixis.chatdonback.entity.Adresse;
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
        Adresse adresse = new Adresse();
        adresse.setCodePostal(75000);
        adresse.setRue("15 rue de la paix");
        adresse.setVille("Paris");
        candidat.setPresenceJardin(false);
        candidat.setSociableChat(false);
        candidat.setSociableChien(false);
        candidat.setTypeHebergement("test");
        candidat.setNom("ERGUN");
        candidat.setPrenom("Mustafa");
        // a faire car erreur flushing ...
        // candidat.setAdresse(adresse);

        //MAPPER
        candidatService.createCandidat (candidat);
    }
}
