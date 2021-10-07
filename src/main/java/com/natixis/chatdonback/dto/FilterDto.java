package com.natixis.chatdonback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilterDto
{
    private String categorieAge;

    private String race;

    private String sexe;

    private String taille;

    private String pelage;

    private String caractere;

    private String zoneGeo;

    private Boolean sociableEnfant;

    private Boolean sociableChat;

    private Boolean sociableChien;
}
