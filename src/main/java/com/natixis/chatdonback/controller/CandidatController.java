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
    public void createCandidat(@RequestBody CreateCandidatDto createCandidatDto)
    {
        //MAPPER
        candidatService.createCandidat (createCandidatDto);
    }
    @GetMapping()
    public void testCreateCandidat()
    {
        CreateCandidatDto createCandidatDto = new CreateCandidatDto();
        candidatService.createCandidat (createCandidatDto);
    }
}
