package com.natixis.chatdonback.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.natixis.chatdonback.dto.CreateCandidatDto;
import com.natixis.chatdonback.dto.GetCandidatDto;
import com.natixis.chatdonback.dto.GetDonateurDto;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.entity.Donateur;
import com.natixis.chatdonback.mapper.CandidatMapper;
import com.natixis.chatdonback.repository.AdresseRepository;
import com.natixis.chatdonback.repository.CandidatRepository;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private CandidatMapper candidatMapper;
    
	@Autowired
	private AdresseRepository adresseRepository;

    public Candidat createCandidat(CreateCandidatDto createCandidatDto){
        return candidatRepository.save( candidatMapper.createCanditatDtoToEntity(createCandidatDto));
    }
    
	public Candidat updateCandidat(Long id, GetCandidatDto getCandidatDto) {
		Optional<Candidat> candidatOptional = candidatRepository.findById(id);
		if (candidatOptional.isPresent()) {
			// Mot de passe à space depuis le front à valoriser par celui en table avant sauvegarde
			getCandidatDto.setMotDePasse1(candidatOptional.get().getMotDePasse());
			// mapper du dto puis sauvegarde de l'adresse avant sauvegarde du donateur
			Candidat getCandidatMappe = candidatMapper.getCandidatDtoToEntity(getCandidatDto);
			adresseRepository.save(getCandidatMappe.getAdresse());
			return candidatRepository.save(getCandidatMappe);	
		}
		return null;	
	}

	public void deleteCandidatById(Long id) {
		candidatRepository.deleteById(id);
	}
	
	public GetCandidatDto getCandidatById(Long id) {
		return candidatMapper.candidatEntityToGetDto(candidatRepository.findById(id).get());
	}
	
    public String chkCandidatByMail(String mail, String pass) {
        Candidat candidat = candidatRepository.getCandidatByMail(mail);
        if (candidat != null) {
            if (passwordEncoder.matches(pass, candidat.getMotDePasse())) {
                return "Candidat";
            }
            return "WrongPass";
        }
        return "";
    }   

	public GetCandidatDto getCandidatByMail(String nom, String pass) throws Exception {
		System.out.println("getCandidatByMail - nom : " + nom );
		Candidat candidat = candidatRepository.getCandidatByMail(nom);
		if (passwordEncoder.matches(pass, candidat.getMotDePasse())) {
			return candidatMapper.candidatEntityToGetDto(candidat);
		}
		throw new Exception("WrongPass");
	}
}
