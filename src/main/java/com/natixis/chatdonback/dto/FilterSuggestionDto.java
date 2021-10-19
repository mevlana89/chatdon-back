package com.natixis.chatdonback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FilterSuggestionDto
{
    private String categorieAge;

    private String race;

    private String sexe;

    private List <String> taille;

    private String pelage;

    private List<String> caractere;

    private String zoneGeo;

    private List <Boolean> sociableEnfant;

    private List <Boolean> sociableChat;

    private List <Boolean> sociableChien;
}
