package com.natixis.chatdonback.controller;


import com.natixis.chatdonback.dto.CreateCandidatureDto;
import com.natixis.chatdonback.entity.Candidature;
import com.natixis.chatdonback.service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin
public class CandidatureController {

    @Autowired
    private CandidatureService candidatureService;

    @GetMapping("/candidats/{candidatId}/candidatures")
    public List<Candidature> findAllCandidaturesByCandidat(@PathVariable Long candidatId){
        System.out.println("findAllCandidaturesByCandidat : " + candidatId);
        try {
            return candidatureService.findAllCandidaturesByCandidatId(candidatId);
        }
        catch (Exception e){
            System.out.println("Exception pour la selection des candidatures par candidat:");
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune candidature trouvée pour le candidat "+ candidatId);
        }


    }

    @PostMapping("/createCandidature")
    public void createCandidatureDto(@RequestBody CreateCandidatureDto createCandidatureDto){
        System.out.println("create candidature");
        candidatureService.createCandidature(createCandidatureDto);
    }

    @DeleteMapping("/candidatures/{id}")
    public void deleteCandidatureById(@PathVariable Integer id){
        System.out.println("delete candidat : " + id);
        candidatureService.deleteCandidatureById(id);
    }



}
