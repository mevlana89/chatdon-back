package com.natixis.chatdonback.service;

import com.natixis.chatdonback.dto.CreateCandidatDto;
import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    public void createCandidat(CreateCandidatDto createCandidatDto)
    {
        Candidat candidat = new Candidat();
        Adresse adresse = new Adresse();

        //MAPPER A FAIRE
//        adresse.setCodePostal(createCandidatDto.getAdresse().getCodePostal());
//        adresse.setRue(createCandidatDto.getAdresse().getRue());
//        adresse.setVille(createCandidatDto.getAdresse().getVille());
//
//        candidat.setPresenceJardin(createCandidatDto.isPresenceJardin());
//        candidat.setSociableChat(createCandidatDto.isSociableChat());
//        candidat.setSociableChien(createCandidatDto.isSociableChien());
//        candidat.setTypeHebergement(createCandidatDto.getTypeHebergement());
//        candidat.setNom(createCandidatDto.getNom());
//        candidat.setPrenom(createCandidatDto.getPrenom());
//        candidat.setAdresse(createCandidatDto.getAdresse());

        adresse.setCodePostal(75000);
        adresse.setRue("15 rue de la paix");
        adresse.setVille("Paris");
        candidat.setPresenceJardin(false);
        candidat.setSociableChat(false);
        candidat.setSociableChien(false);
        candidat.setTypeHebergement("test");
        candidat.setNom("ERGUN");
        candidat.setPrenom("Mustafa");
        candidat.setAdresse(adresse);

        candidatRepository.save(candidat);
    }
}
