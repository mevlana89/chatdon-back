package com.natixis.chatdonback.service;

import com.natixis.chatdonback.dto.GetDonateurDto;
import com.natixis.chatdonback.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Donateur;
import com.natixis.chatdonback.mapper.DonateurMapper;
import com.natixis.chatdonback.repository.DonateurRepository;

import java.util.List;

@Service
public class DonateurService {
	
	@Autowired
	private DonateurRepository donateurRepository;
	
	@Autowired
	private DonateurMapper donateurMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Donateur createDonateur(CreateDonateurDto  createDonateurDto) {
		return donateurRepository.save( donateurMapper.createDonateurDtoToEntity(createDonateurDto) );
	}
	
	public void deleteDonateurById(Long id) {
		donateurRepository.deleteById(id);
	}
	
	public GetDonateurDto getDonateurById(Long id) {
		System.out.println("adressedto : " + donateurMapper.donateurEntityToGetDto(donateurRepository.findById(id).get()).getAdresseDTO());
		return donateurMapper.donateurEntityToGetDto(donateurRepository.findById(id).get());
	}

	public GetDonateurDto getDonateurDtoByMail(String nom) {
		Donateur donateur = donateurRepository.getDonateurByMail(nom);
		return donateurMapper.donateurEntityToGetDto(donateur);
	}

	public Donateur getDonateurByMail(String nom) {
		Donateur donateur = donateurRepository.getDonateurByMail(nom);
		return donateur;
	}

	public String chkDonateurByMail(String mail, String pass) {
		Donateur donateur = donateurRepository.getDonateurByMail(mail);
		if (donateur != null) {
			if (passwordEncoder.matches(pass, donateur.getMotDePasse())) {
				return "Donateur";
			}
			return "Donateur";
			//FIXME : return "WrongPass";
		}
		return "";
    }

    public List<Chat> findAllCatsByDonatorId(Long id)
	{
		return donateurRepository.findById(id).get().getChatsProposes();
    }
}
