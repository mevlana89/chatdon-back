package com.natixis.chatdonback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.natixis.chatdonback.dto.GetDonateurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.entity.Donateur;

@Component
public class DonateurMapper {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
    public Donateur createDonateurDtoToEntity(CreateDonateurDto createDonateurDto) {
        if ( createDonateurDto == null ) {
            return null;
        }

        Donateur donateur = new Donateur();
        System.out.println("mapper createdto to entity");

        donateur.setNom( createDonateurDto.getNom() );
        donateur.setPrenom( createDonateurDto.getPrenom() );
        donateur.setMail( createDonateurDto.getMail() );
        donateur.setTelephone( createDonateurDto.getTelephone() );
        donateur.setMotDePasse( passwordEncoder.encode( createDonateurDto.getMotDePasse1() ) ); 
        
        AdresseDTO adDto = createDonateurDto.getAdresseDTO();
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
    
    public CreateDonateurDto donateurEntityToCreateDto(Donateur donateur) {
        if ( donateur == null ) {
            return null;
        }

        CreateDonateurDto createDonateurDto = new CreateDonateurDto();
        
        System.out.println("mapper entity to createdto");

        createDonateurDto.setNom( donateur.getNom() );
        createDonateurDto.setPrenom( donateur.getPrenom() );
        createDonateurDto.setMail( donateur.getMail() );
        createDonateurDto.setTelephone( donateur.getTelephone() );
        createDonateurDto.setMotDePasse1( donateur.getMotDePasse() ); 

        System.out.println("mapper adresse");
        Adresse ad = donateur.getAdresse();
        AdresseDTO adDto = new AdresseDTO();
        adDto.setRue( ad.getRue() );
        adDto.setVille( ad.getVille() );
        adDto.setCodePostal( ad.getCodePostal() ) ;
        createDonateurDto.setAdresseDTO( adDto );
        
        System.out.println("mapper chatsproposes");
        List<Chat> list = donateur.getChatsProposes();
        if ( list != null ) {
        	createDonateurDto.setChatsProposes( new ArrayList<Chat>( list ) );
        }
        return createDonateurDto;
    }

    public Donateur getDonateurDtoToEntity(GetDonateurDto getDonateurDto) {
        if ( getDonateurDto == null ) {
            return null;
        }

        Donateur donateur = new Donateur();
        System.out.println("mapper getDto to entity");
        donateur.setId(getDonateurDto.getId());
        donateur.setNom( getDonateurDto.getNom() );
        donateur.setPrenom( getDonateurDto.getPrenom() );
        donateur.setMail( getDonateurDto.getMail() );
        donateur.setTelephone( getDonateurDto.getTelephone() );
        donateur.setMotDePasse( passwordEncoder.encode( getDonateurDto.getMotDePasse1() ) );

        AdresseDTO adDto = getDonateurDto.getAdresseDTO();
        Adresse ad = new Adresse();
        ad.setRue( adDto.getRue() );
        ad.setVille( adDto.getVille() );
        ad.setCodePostal( adDto.getCodePostal() ) ;
        donateur.setAdresse( ad );

        List<Chat> list = getDonateurDto.getChatsProposes();
        if ( list != null ) {
            donateur.setChatsProposes( new ArrayList<Chat>( list ) );
        }
        return donateur;
    }

    public GetDonateurDto donateurEntityToGetDto(Donateur donateur) {
        if ( donateur == null ) {
            return null;
        }

        GetDonateurDto getDonateurDto = new GetDonateurDto();

        System.out.println("mapper entity to getDto");
        getDonateurDto.setId(donateur.getId());
        getDonateurDto.setNom( donateur.getNom() );
        getDonateurDto.setPrenom( donateur.getPrenom() );
        getDonateurDto.setMail( donateur.getMail() );
        getDonateurDto.setTelephone( donateur.getTelephone() );
        getDonateurDto.setMotDePasse1( donateur.getMotDePasse() );

        System.out.println("mapper adresse");
        Adresse ad = donateur.getAdresse();
        AdresseDTO adDto = new AdresseDTO();
        adDto.setRue( ad.getRue() );
        adDto.setVille( ad.getVille() );
        adDto.setCodePostal( ad.getCodePostal() ) ;
        getDonateurDto.setAdresseDTO( adDto );

        System.out.println("mapper chatsproposes");
        List<Chat> list = donateur.getChatsProposes();
        if ( list != null ) {
            getDonateurDto.setChatsProposes( new ArrayList<Chat>( list ) );
        }
        return getDonateurDto;
    }


}