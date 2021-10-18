package com.natixis.chatdonback.controller;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateCandidatDto;
import com.natixis.chatdonback.dto.GetCandidatDto;
import com.natixis.chatdonback.dto.GetDonateurDto;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.entity.Donateur;
import com.natixis.chatdonback.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
//@RequestMapping({ "/candidats" })
@CrossOrigin("*")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;
    
	@Autowired
	PasswordEncoder passwordEncoder;

    @PostMapping()
    public void createCandidat(@RequestBody CreateCandidatDto createCandidatDto) {
        candidatService.createCandidat (createCandidatDto);
    }

    @GetMapping("/getCandidatbyMail")
    public Candidat getCandidatbyMail(@RequestParam String mail) {
        return candidatService.getCandidatByMail(mail);
    }
    
	@GetMapping("/candidat/{id}")
	public GetCandidatDto getCandidatById(@PathVariable Long id){
        System.out.println("getCandidatById : " + id);
        try
        {
        	System.out.println("donateur (get donateur):" + candidatService.getCandidatById(id));
          return candidatService.getCandidatById(id);
        } catch (Exception ex) {
            System.out.println("Exception getCandidatById : " + ex.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "donateur non trouvé pour id "+id);
        }
	}

	@DeleteMapping("/candidat/{id}")
	public void deleteDonateurById(@PathVariable Long id){
	    System.out.println("delete candidat : " + id);
	    candidatService.deleteCandidatById(id);   
	}
	
	@PostMapping("/candidat/{id}")
	public void updateDonateur(@PathVariable Long id, @RequestBody GetCandidatDto getCandidatDto) {
		System.out.println("updateCandidat" + id);
		candidatService.updateCandidat(id, getCandidatDto);
	}

    // methodes de tests
	@GetMapping("/TestDeleteCandidat/{id}")
	public void testDeleteDonateurById(@PathVariable Long id) {
		candidatService.deleteCandidatById(id);
	}

    @GetMapping("/TestCreateCandidat")
    public void testCreateCandidat() {
      CreateCandidatDto createCandidatDto = new CreateCandidatDto();
      AdresseDTO adresse = new AdresseDTO();
      adresse.setCodePostal(75000);
      adresse.setRue("15 rue de la paix");
      adresse.setVille("Paris");
      createCandidatDto.setPresenceJardin(false);
      createCandidatDto.setSociableChat(true);
      createCandidatDto.setSociableChien(false);
      createCandidatDto.setTypeHebergement("test");
      createCandidatDto.setNom("Bond");
      createCandidatDto.setPrenom("James");
      createCandidatDto.setAdresseDTO(adresse);
      createCandidatDto.setMail("mailC");
      createCandidatDto.setMotDePasse1(passwordEncoder.encode("mdp"));
      System.out.println("testCreateCandidat");
      candidatService.createCandidat (createCandidatDto);
    }
}
