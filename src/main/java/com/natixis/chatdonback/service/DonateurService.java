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
	
	public Donateur getDonateurById(Long id) {
		return donateurRepository.findById(id).get();		
	}

	public Donateur getDonateurByMail(String nom) {
		return donateurRepository.getDonateurByMail(nom);
	}

	public String chkDonateurByMail(String nom, String pass) {
		Donateur donateur = donateurRepository.getDonateurByMail(nom);
		if (donateur != null) {
			if (donateur.getMotDePasse().equals(pass)) {
				return "Donateur";
			}
			return "WrongPass";
		}
		return "";
    }
}
