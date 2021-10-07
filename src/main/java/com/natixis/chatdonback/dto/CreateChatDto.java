package com.natixis.chatdonback.dto;

import java.util.List;

import com.natixis.chatdonback.entity.Donateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreateChatDto {

    private String nom;
    
    private String categorieAge;
    
    private String race;
    
    private String sexe;
    
    private String taille;
    
    private String pelage;
    
    private String caractere;
    
    private String zoneGeo;
    
    private String descriptif;
    
    private boolean sociableEnfant;
    
    private boolean sociableChat;
    
    private boolean sociableChien;

    private List<CreatePhotoChatDto> lstPhotos;

    private Donateur donateur;

}
