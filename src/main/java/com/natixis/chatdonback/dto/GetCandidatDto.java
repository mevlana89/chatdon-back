package com.natixis.chatdonback.dto;

import java.util.List;

import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Candidature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCandidatDto {

    private Long id;
	private String nom;
    private String prenom;
    private String mail;
    private Adresse adresseDTO;
    private String telephone;
    private String motDePasse1;
    private String motDePasse2;
    private String typeHebergement;
    private int surfaceHebergement;
    private boolean presenceJardin;
    private boolean sociableChat;
    private boolean sociableChien;
    private int ageBenjamin;
    private List<Candidature> candidatures;

}