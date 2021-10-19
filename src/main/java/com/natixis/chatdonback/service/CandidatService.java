package com.natixis.chatdonback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.natixis.chatdonback.dto.FilterSuggestionDto;
import com.natixis.chatdonback.entity.Chat;
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
    ChatService chatService;

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
            //return "WrongPass";
            return "Candidat";
        }
        return "";
    }   

    public Candidat getCandidatByMail(String mail) {
        return candidatRepository.getCandidatByMail(mail);
    }

    public List<Chat> suggestCatsByCandidatId(FilterSuggestionDto filterSuggestionDto, Long id)
    {
        Optional<Candidat> candidat = candidatRepository.findById(id);

        algoSuggestionsCats( candidat.get(), filterSuggestionDto );

        return chatService.suggestCatsByCandidat(filterSuggestionDto);
    }

    private FilterSuggestionDto algoSuggestionsCats(Candidat candidat, FilterSuggestionDto filterSuggestionDto)
    {

        // initialisation du filtre avant le dev du front
        filterSuggestionDto.setCategorieAge("");
        filterSuggestionDto.setPelage("");
        filterSuggestionDto.setSexe("");
        filterSuggestionDto.setZoneGeo("");
        //filterSuggestionDto.setZoneGeo(candidat.getAdresse().getCodePostal());
        filterSuggestionDto.setRace("");

        //initialisation du filtre
        List <String> caractere = new ArrayList<>();
        caractere.add("calme");
        caractere.add("joueur");
        caractere.add("solitaire");
        caractere.add("affectueux");
        caractere.add("bagarreur");
        filterSuggestionDto.setCaractere(caractere);

        List <String> taille = new ArrayList<>();
        taille.add("petit");
        taille.add("moyen");
        taille.add("grand");
        filterSuggestionDto.setTaille(taille);

        List<Boolean> colSociableEnfant = new ArrayList<>();
        filterSuggestionDto.setSociableEnfant(colSociableEnfant);

        List<Boolean> colSociableChat = new ArrayList<>();
        filterSuggestionDto.setSociableChat(colSociableChat);

        List<Boolean> colSociableChien = new ArrayList<>();
        filterSuggestionDto.setSociableChien(colSociableChien);

        // si candidat n'a pas de jardin et surface hebergement <80 m² OU si candidat a un jardin et surface hebergement < 40m²
        if (!candidat.isPresenceJardin() && candidat.getSurfaceHebergement() < 80 || candidat.isPresenceJardin() && candidat.getSurfaceHebergement() < 40)
        {
            filterSuggestionDto.getCaractere().remove("bagarreur");
            filterSuggestionDto.getCaractere().remove("joueur");
            filterSuggestionDto.getTaille().remove("grand");
        }

        //Si candidat à au moins un chat
        if (candidat.isSociableChat())
        {
            filterSuggestionDto.getSociableChat().add(true);
        }else {
            filterSuggestionDto.getSociableChat().add(false);
            filterSuggestionDto.getSociableChat().add(true);
        }

        //Si candidat à au moins un chien
        if (candidat.isSociableChien())
        {
            filterSuggestionDto.getSociableChien().add(true);
        }else {
            filterSuggestionDto.getSociableChien().add(false);
            filterSuggestionDto.getSociableChien().add(true);
        }

        //Si candidat à un enfant de moins de 10 ans
        if (candidat.getAgeBenjamin() < 10 )
        {
            filterSuggestionDto.getCaractere().remove("bagarreur");
            filterSuggestionDto.getSociableEnfant().add(true);
        }else {
            filterSuggestionDto.getSociableEnfant().add(false);
            filterSuggestionDto.getSociableEnfant().add(true);
        }


        return filterSuggestionDto;

        // taille, caractere, sociable, (environnement souhaitable)
        //
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
