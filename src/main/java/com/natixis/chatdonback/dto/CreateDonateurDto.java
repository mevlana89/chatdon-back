package com.natixis.chatdonback.dto;

import java.util.List;

import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreateDonateurDto {
    private String nom;
    private String prenom;
    private String mail;
    private AdresseDTO adresseDto;
    private String telephone;
    private String motDePasse;
    private List<Chat> chatsProposes;
}