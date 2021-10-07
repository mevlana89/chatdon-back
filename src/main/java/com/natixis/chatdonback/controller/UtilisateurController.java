package com.natixis.chatdonback.controller;

import com.natixis.chatdonback.service.CandidatService;
import com.natixis.chatdonback.service.DonateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UtilisateurController {

    @Autowired
    private DonateurService donateurService;

    @Autowired
    private CandidatService candidatService;

    @GetMapping("/getProfilutilisateur")
    public String getProfilutilisateur(@RequestParam String mail, @RequestParam String pass) {
        String reponse = donateurService.chkDonateurByMail(mail, pass);
        if (!reponse.equals("")) {
            return reponse;
        }
        reponse = candidatService.chkCandidatByMail(mail, pass);
        if (!reponse.equals("")) {
            return reponse;
        }
        return "";
    }


}
