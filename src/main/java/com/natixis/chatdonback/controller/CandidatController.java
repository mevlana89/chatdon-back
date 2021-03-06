package com.natixis.chatdonback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateCandidatDto;
import com.natixis.chatdonback.dto.FilterSuggestionDto;
import com.natixis.chatdonback.dto.GetCandidatDto;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.service.CandidatService;

@RestController
//@RequestMapping({ "/candidats" })
@CrossOrigin("*")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;
    
	@Autowired
	PasswordEncoder passwordEncoder;

    @PostMapping("/candidats")
    public void createCandidat(@RequestBody CreateCandidatDto createCandidatDto) {
    	System.out.println("createCandidat ctrl");
        candidatService.createCandidat (createCandidatDto);
    }

    @GetMapping("/getCandidatbyMail")
    public GetCandidatDto getCandidatbyMail(@RequestParam String mail, @RequestParam String pass) throws Exception {
    	System.out.println("getCandidatbyMail" + mail);
        return candidatService.getCandidatByMail(mail, pass);
    }

    
	@GetMapping("/candidats/{id}")
	public GetCandidatDto getCandidatById(@PathVariable Long id){
        System.out.println("getCandidatById : " + id);
        try
        {
        	System.out.println("candidat (get candidat):" + candidatService.getCandidatById(id));
          return candidatService.getCandidatById(id);
        } catch (Exception ex) {
            System.out.println("Exception getCandidatById : " + ex.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "candidat non trouv?? pour id "+id);
        }
	}

	@DeleteMapping("/candidats/{id}")
	public void deleteCandidatById(@PathVariable Long id){
	    System.out.println("delete candidat : " + id);
	    candidatService.deleteCandidatById(id);   
	}
	
	@PostMapping("/candidats/{id}")
	public void updateCandidat(@PathVariable Long id, @RequestBody GetCandidatDto getCandidatDto) {
		System.out.println("updateCandidat" + id);
		candidatService.updateCandidat(id, getCandidatDto);
	}

    // methodes de tests
	@GetMapping("/TestDeleteCandidat/{id}")
	public void testDeleteCandidatById(@PathVariable Long id) {
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
      createCandidatDto.setMail("mail@test.fr");
      createCandidatDto.setMotDePasse1(passwordEncoder.encode("mdp"));
      createCandidatDto.setSurfaceHebergement(79);
      createCandidatDto.setAgeBenjamin(14);
      createCandidatDto.setTypeHebergement("Maison");
      System.out.println("testCreateCandidat");
      candidatService.createCandidat (createCandidatDto);
    }

    @GetMapping("/candidats/{id}/suggestions")
    public List<Chat> suggestCatsByCandidatId(FilterSuggestionDto filterSuggestionDto, @PathVariable Long id)
    {
        return candidatService.suggestCatsByCandidatId(filterSuggestionDto, id);
    }
}
