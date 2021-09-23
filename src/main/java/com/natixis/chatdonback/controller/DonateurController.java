package com.natixis.chatdonback.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.mapper.DonateurMapper;
import com.natixis.chatdonback.service.DonateurService;

@RestController
public class DonateurController {
	
	@Autowired
	private DonateurService donateurService;
	
	@PostMapping("/donateurs")
	public void createDonateur(CreateDonateurDto createDonateurDto) {
		
	    final DonateurMapper donateurMapper = Mappers.getMapper(DonateurMapper.class);
		donateurService.createDonateur(donateurMapper.donateurDtoToEntity(createDonateurDto));
	}

		
}
