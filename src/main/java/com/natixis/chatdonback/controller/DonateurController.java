package com.natixis.chatdonback.controller;

// import org.mapstruct.factory.Mappers;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.entity.Donateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Donateur;
import com.natixis.chatdonback.mapper.DonateurMapper;
import com.natixis.chatdonback.service.DonateurService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DonateurController {
	
	@Autowired
	private DonateurService donateurService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/donateurs")
	public void createDonateur(@RequestBody CreateDonateurDto donateurDto) {
		System.out.println("ctrl : save donateur");
		donateurService.createDonateur(donateurDto);
	}

	@GetMapping("/donateurs/{id}")
	public Donateur getDonateurById(@PathVariable Long id){
        System.out.println("getDonateurById : " + id);
        try
        {

            return donateurService.getDonateurById(id);
        } catch (Exception ex) {
            System.out.println("Exception getDonateurById : " + ex.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "donateur non trouvé pour id "+id);
        }
	}
	
	@DeleteMapping("/donateurs/{id}")
	public void deleteDonateurById(@PathVariable Long id){
	    System.out.println("delete donateur : " + id);
	    donateurService.deleteDonateurById(id);   
	}
	
	@GetMapping("/TestCreationDonateur")
	public void testCreateDonateur() {
		CreateDonateurDto donnateurDtoTest = new CreateDonateurDto();
		AdresseDTO adresseDto = new AdresseDTO();
		donnateurDtoTest.setNom("Dupond");
		donnateurDtoTest.setPrenom("Jean");
		donnateurDtoTest.setMail("dupond.jean@orange.fr");
		donnateurDtoTest.setMotDePasse1(passwordEncoder.encode("mdp"));
		donnateurDtoTest.setTelephone("00-00-00-00");
		adresseDto.setRue("10 rue de paris");
		adresseDto.setCodePostal(75000);
		adresseDto.setVille("paris");
		donnateurDtoTest.setAdresseDTO(adresseDto);
		donateurService.createDonateur(donnateurDtoTest);
	}

	@GetMapping("/getDonateurbyMail")
	public Donateur getDonateurbyMail(@RequestParam String mail, @RequestParam String pass) throws Exception {
		System.out.println("getDonateur pour " + mail);
		Donateur donateur = donateurService.getDonateurByMail(mail);
		if (passwordEncoder.matches(pass, donateur.getMotDePasse())) {
			return donateurService.getDonateurByMail(mail);
		}
		throw new Exception("WrongPass");
	}


	@GetMapping("/TestDeleteDonateur/{id}")
	public void testDeleteDonateurById(@PathVariable Long id) {
		donateurService.deleteDonateurById(id);
	}

	@GetMapping("/donateurs/{id}/chats")
	public List<Chat> getllCatsByDonatorId(@PathVariable Long id) {
		return donateurService.findAllCatsByDonatorId(id);
	}
}