package com.natixis.chatdonback.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.natixis.chatdonback.dto.AdresseDTO;
import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.dto.GetDonateurDto;
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
        if (adDto != null) {
            Adresse ad = new Adresse();
            ad.setRue( adDto.getRue() );
            ad.setVille( adDto.getVille() );
            ad.setCodePostal( adDto.getCodePostal() ) ;
            donateur.setAdresse( ad );
        }
        List<Chat> list = createDonateurDto.getChatsProposes();
        if ( list != null ) {
            donateur.setChatsProposes( new ArrayList<Chat>( list ) );
        }
        return donateur;
    }

    public Donateur getDonateurDtoToEntity(GetDonateurDto getDonateurDto) {
        if ( getDonateurDto == null ) {
            return null;
        }

        Donateur donateur = new Donateur();
        System.out.println("mapper get Dto to entity");
        donateur.setId(getDonateurDto.getId());
        donateur.setNom( getDonateurDto.getNom() );
        donateur.setPrenom( getDonateurDto.getPrenom() );
        donateur.setMail( getDonateurDto.getMail() );
        donateur.setTelephone( getDonateurDto.getTelephone() );
        if (getDonateurDto.getMotDePasse1() != null) {
            donateur.setMotDePasse(passwordEncoder.encode(getDonateurDto.getMotDePasse1()));
        }
        
        Adresse adDto = getDonateurDto.getAdresseDTO();
        if (adDto != null) {
            Adresse ad = new Adresse();
            ad.setId(adDto.getId());
            ad.setRue( adDto.getRue() );
            ad.setVille( adDto.getVille() );
            ad.setCodePostal( adDto.getCodePostal() ) ;
            donateur.setAdresse( ad );   
        }

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
        // pas d'envoi du mot de passe vers le front
        // getDonateurDto.setMotDePasse1( "" );

//        System.out.println("mapper adresse");
//        Adresse ad = donateur.getAdresse();
//        if (ad != null) {
//            AdresseDTO adDto = new AdresseDTO();
//            adDto.setRue(ad.getRue());
//            adDto.setVille(ad.getVille());
//            adDto.setCodePostal(ad.getCodePostal());
//            getDonateurDto.setAdresseDTO(adDto);
//        }
//        System.out.println("mapper chatsproposes");
        getDonateurDto.setAdresseDTO(donateur.getAdresse());
        
        List<Chat> list = donateur.getChatsProposes();
        if ( list != null ) {
            getDonateurDto.setChatsProposes( new ArrayList<Chat>( list ) );
        }
        return getDonateurDto;
    }
}