package com.natixis.chatdonback.controller;


import com.natixis.chatdonback.entity.Candidature;
import com.natixis.chatdonback.service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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

//    @GetMapping("/chats/{id}/candidatures")
//    public Candidature indAllCandidaturesByCat(@PathVariable Integer id){
//        System.out.println("findAllCandidaturesByCandidat : " + id);
//        try{
//            return candidatureService.findAllCandidaturesByCat(id);
//        }
//        catch (Exception e){
//            System.out.println("Exception pour la selection des candidatures par candidat:" + e.getMessage());
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune candidature trouvée pour le chat "+id);
//        }
//    }

}
