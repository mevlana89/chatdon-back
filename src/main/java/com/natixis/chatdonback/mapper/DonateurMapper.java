package com.natixis.chatdonback.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.entity.Donateur;

@Component
public class DonateurMapper {
	
    public Donateur donateurDtoToEntity(CreateDonateurDto createDonateurDto) {
        if ( createDonateurDto == null ) {
            return null;
        }

        Donateur donateur = new Donateur();

        donateur.setNom( createDonateurDto.getNom() );
        donateur.setPrenom( createDonateurDto.getPrenom() );
        donateur.setMail( createDonateurDto.getMail() );
        donateur.setTelephone( createDonateurDto.getTelephone() );
        donateur.setMotDePasse( createDonateurDto.getMotDePasse() ); 
        
        AdresseDTO adDto = createDonateurDto.getAdresseDto();
        Adresse ad = new Adresse();
        ad.setRue( adDto.getRue() );
        ad.setVille( adDto.getVille() );
        ad.setCodePostal( adDto.getCodePostal() ) ;
        donateur.setAdresse( ad );
        
        List<Chat> list = createDonateurDto.getChatsProposes();
        if ( list != null ) {
            donateur.setChatsProposes( new ArrayList<Chat>( list ) );
        }
        return donateur;
    }
    
    public CreateDonateurDto donateurEntityToDto(Donateur donateur) {
        if ( donateur == null ) {
            return null;
        }

        CreateDonateurDto createDonateurDto = new CreateDonateurDto();

        createDonateurDto.setNom( donateur.getNom() );
        createDonateurDto.setPrenom( donateur.getPrenom() );
        createDonateurDto.setMail( donateur.getMail() );
        createDonateurDto.setTelephone( donateur.getTelephone() );
        createDonateurDto.setMotDePasse( donateur.getMotDePasse() ); 

        
        Adresse ad = donateur.getAdresse();
        AdresseDTO adDto = new AdresseDTO();
        adDto.setRue( ad.getRue() );
        adDto.setVille( ad.getVille() );
        adDto.setCodePostal( ad.getCodePostal() ) ;
        createDonateurDto.setAdresseDto( adDto );
        
        List<Chat> list = donateur.getChatsProposes();
        if ( list != null ) {
        	createDonateurDto.setChatsProposes( new ArrayList<Chat>( list ) );
        }
        return createDonateurDto;
    }
}