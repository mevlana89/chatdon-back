package com.natixis.chatdonback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class UtilisateurDTO
{
    private String nom;

    private String prenom;

    private String mail;

    private AdresseDTO adresseDTO;

    private String telephone;

    private String motDePasse1;

    private String motDePasse2;
}
