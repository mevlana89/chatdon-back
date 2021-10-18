package com.natixis.chatdonback.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateCandidatDto;
import com.natixis.chatdonback.dto.GetCandidatDto;
import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Candidat;
import com.natixis.chatdonback.entity.Candidature;

@Component
public class CandidatMapper {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Candidat createCanditatDtoToEntity (CreateCandidatDto createCandidatDto) {
		if (createCandidatDto == null) {
			return null;
		}
		System.out.println("mapper condidat - dto to entity ");
		
	    Candidat candidat = new Candidat();
	    candidat.setNom( createCandidatDto.getNom() );
	    candidat.setPrenom( createCandidatDto.getPrenom() );
	    candidat.setMail( createCandidatDto.getMail() );
	    candidat.setTelephone( createCandidatDto.getTelephone() );
	    candidat.setMotDePasse( passwordEncoder.encode( createCandidatDto.getMotDePasse1() ) ); 
	        
	    AdresseDTO adDto = createCandidatDto.getAdresseDTO();
	    if (adDto != null) {
	       Adresse ad = new Adresse();
	       ad.setRue( adDto.getRue() );
	       ad.setVille( adDto.getVille() );
	       ad.setCodePostal( adDto.getCodePostal() ) ;
	       candidat.setAdresse( ad );
	    }
	    
	    candidat.setTypeHebergement(createCandidatDto.getTypeHebergement());;
	    candidat.setPresenceJardin(createCandidatDto.isPresenceJardin());
	    candidat.setSurfaceHebergement(createCandidatDto.getSurfaceHebergement());
	    candidat.setNbEnfant(createCandidatDto.getNbEnfant());
	    candidat.setAgeBenjamin(createCandidatDto.getAgeBenjamin());
	    candidat.setSociableChat(createCandidatDto.isSociableChat());
	    candidat.setSociableChien(createCandidatDto.isSociableChien());
	    
	    List<Candidature> listCandidatures = createCandidatDto.getCandidatures();
	    if ( listCandidatures != null ) {
	       candidat.setCandidatures( new ArrayList<Candidature>( listCandidatures ) );
	    }
	    
		return candidat;
	}
	
    public Candidat getCandidatDtoToEntity(GetCandidatDto getCandidatDto) {
        if ( getCandidatDto == null ) {
            return null;
        }

        Candidat candidat = new Candidat();
        System.out.println("mapper Candidat - get Dto to entity");
        candidat.setId(getCandidatDto.getId());
        candidat.setNom( getCandidatDto.getNom() );
        candidat.setPrenom( getCandidatDto.getPrenom() );
        candidat.setMail( getCandidatDto.getMail() );
        candidat.setTelephone( getCandidatDto.getTelephone() );
        if (getCandidatDto.getMotDePasse1() != null) {
        	candidat.setMotDePasse(passwordEncoder.encode(getCandidatDto.getMotDePasse1()));
        }
        
        Adresse adDto = getCandidatDto.getAdresseDTO();
        if (adDto != null) {
            Adresse ad = new Adresse();
            ad.setId(adDto.getId());
            ad.setRue( adDto.getRue() );
            ad.setVille( adDto.getVille() );
            ad.setCodePostal( adDto.getCodePostal() ) ;
            candidat.setAdresse( ad );   
        }

        candidat.setTypeHebergement(getCandidatDto.getTypeHebergement());
        candidat.setSurfaceHebergement(getCandidatDto.getSurfaceHebergement());
        candidat.setNbEnfant(getCandidatDto.getNbEnfant());
        candidat.setAgeBenjamin(getCandidatDto.getAgeBenjamin());
        candidat.setPresenceJardin(getCandidatDto.isPresenceJardin());
        candidat.setSociableChat(getCandidatDto.isSociableChat());
        candidat.setSociableChien(getCandidatDto.isSociableChien());
	    
        List<Candidature> listCandidatures = getCandidatDto.getCandidatures();
	    if ( listCandidatures != null ) {
	       candidat.setCandidatures( new ArrayList<Candidature>( listCandidatures ) );
	    }
	    
        return candidat;
    }
	
	
	public GetCandidatDto candidatEntityToGetDto(Candidat candidat) {
	    if ( candidat == null ) {
	            return null;
	    }

	    GetCandidatDto getCandidatDto = new GetCandidatDto();

	    System.out.println("mapper Candidat - entity to getDto");
	    getCandidatDto.setId(candidat.getId());
	    getCandidatDto.setNom( candidat.getNom() );
	    getCandidatDto.setPrenom( candidat.getPrenom() );
	    getCandidatDto.setMail( candidat.getMail() );
	    getCandidatDto.setTelephone( candidat.getTelephone() );
	    getCandidatDto.setAdresseDTO(candidat.getAdresse());
	    
	    getCandidatDto.setTypeHebergement(candidat.getTypeHebergement());
	    getCandidatDto.setSurfaceHebergement(candidat.getSurfaceHebergement());
	    getCandidatDto.setNbEnfant(candidat.getNbEnfant());
	    getCandidatDto.setAgeBenjamin(candidat.getAgeBenjamin());
	    getCandidatDto.setPresenceJardin(candidat.isPresenceJardin());
	    getCandidatDto.setSociableChat(candidat.isSociableChat());
	    getCandidatDto.setSociableChien(candidat.isSociableChien());
	    
        List<Candidature> listCandidatures = getCandidatDto.getCandidatures();
	    if ( listCandidatures != null ) {
	       candidat.setCandidatures( new ArrayList<Candidature>( listCandidatures ) );
	    }
	    
	    return getCandidatDto;
	}

}