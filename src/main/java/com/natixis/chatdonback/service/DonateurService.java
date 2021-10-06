package com.natixis.chatdonback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Donateur;
import com.natixis.chatdonback.mapper.DonateurMapper;
import com.natixis.chatdonback.repository.DonateurRepository;

@Service
public class DonateurService {
	
	@Autowired
	private DonateurRepository donateurRepository;
	
	@Autowired
	private DonateurMapper donateurMapper;
	
	public Donateur createDonateur(CreateDonateurDto  createDonateurDto) {
		return donateurRepository.save( donateurMapper.donateurDtoToEntity(createDonateurDto) );
	}
	
	public void deleteDonateurById(Long id) {
		donateurRepository.deleteById(id);
	}
	
}
