package com.natixis.chatdonback.controller;

// import org.mapstruct.factory.Mappers;
import com.natixis.chatdonback.entity.Donateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.mapper.DonateurMapper;
import com.natixis.chatdonback.service.DonateurService;

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

	@GetMapping("/donateurs")
	public void testCreateDonateur() {
		CreateDonateurDto donnateurDtoTest = new CreateDonateurDto();
		AdresseDTO adresseDto = new AdresseDTO();
		donnateurDtoTest.setNom("Dupond");
		donnateurDtoTest.setPrenom("Jean");
		donnateurDtoTest.setMail("dupond.jean@orange.fr");
		donnateurDtoTest.setMotDePasse(passwordEncoder.encode("mdp"));
		donnateurDtoTest.setTelephone("00-00-00-00");
		adresseDto.setRue("10 rue de paris");
		adresseDto.setCodePostal(75000);
		adresseDto.setVille("paris");
		donnateurDtoTest.setAdresseDto(adresseDto);
		donateurService.createDonateur(donnateurDtoTest);
	}

	@GetMapping("/getDonateurbyMail")
	public Donateur getDonateurbyMail(@RequestParam String mail, @RequestParam String pass) throws Exception {
		System.out.println("getDonateur pour " + mail);
		Donateur donateur = donateurService.getDonateurByMail(mail);
		if (donateur.getMotDePasse().equals(passwordEncoder.encode(pass))) {
			return donateurService.getDonateurByMail(mail);
		}
		throw new Exception("WrongPass");
	}

}