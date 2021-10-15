package com.natixis.chatdonback.controller;

import com.natixis.chatdonback.dto.GetDonateurDto;
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
import com.natixis.chatdonback.service.DonateurService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class DonateurController {
	
	@Autowired
	private DonateurService donateurService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/donateurs")
	public void createDonateur(@RequestBody CreateDonateurDto donateurDto) {
		System.out.println("ctrl : save donateur" + donateurDto.getAdresseDTO() );
		donateurService.createDonateur(donateurDto);
	}

	@PostMapping("/donateurs/{id}")
	public void updateDonateur(@PathVariable Long id, @RequestBody GetDonateurDto getDonateurDto) {
		System.out.println("updateDonateur" + id);
		donateurService.updateDonateur(id, getDonateurDto);
	}

	@GetMapping("/donateurs/{id}")
	public GetDonateurDto getDonateurById(@PathVariable Long id){
        System.out.println("getDonateurById : " + id);
        try
        {
        	System.out.println("donateur (get donateur):" + donateurService.getDonateurById(id));
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
		CreateDonateurDto donateurDtoTest = new CreateDonateurDto();
		AdresseDTO adresseDto = new AdresseDTO();
		donateurDtoTest.setNom("Dupond");
		donateurDtoTest.setPrenom("Jean");
		donateurDtoTest.setMail("dupond.jean@orange.fr");
		donateurDtoTest.setMotDePasse1(passwordEncoder.encode("mdp"));
		donateurDtoTest.setTelephone("00-00-00-00");
		adresseDto.setRue("10 rue de paris");
		adresseDto.setCodePostal(75000);
		adresseDto.setVille("paris");
		donateurDtoTest.setAdresseDTO(adresseDto);
		donateurService.createDonateur(donateurDtoTest);
	}

	@GetMapping("/getDonateurbyMail")
	public GetDonateurDto getDonateurbyMail(@RequestParam String mail, @RequestParam String pass) throws Exception {
		System.out.println("getDonateur pour " + mail);
		return donateurService.getDonateurByMail(mail, pass);
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