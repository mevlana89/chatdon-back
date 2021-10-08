package com.natixis.chatdonback.dto;

import com.natixis.chatdonback.entity.Donateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetChatDto {
    
    private int id;

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

    private Donateur donateur;

    private List<GetPhotoChatDto> lstGetPhotoChatDto;

}
