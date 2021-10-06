package com.natixis.chatdonback.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.mapper.DonateurMapper;
import com.natixis.chatdonback.service.DonateurService;

@RestController
@CrossOrigin
public class DonateurController {
	
	@Autowired
	private DonateurService donateurService;
	
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
		donnateurDtoTest.setMotDePasse("mdp");
		donnateurDtoTest.setTelephone("00-00-00-00");
		adresseDto.setRue("10 rue de paris");
		adresseDto.setCodePostal(75000);
		adresseDto.setVille("paris");
		donnateurDtoTest.setAdresseDto(adresseDto);
		donateurService.createDonateur(donnateurDtoTest);
		
	}
		
}