package com.natixis.chatdonback.dto;

import java.util.List;

import com.natixis.chatdonback.entity.Adresse;
import com.natixis.chatdonback.entity.Chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDonateurDto {
//public class GetDonateurDto extends CreateDonateurDto {

    private Long id;
	private String nom;
    private String prenom;
    private String mail;
    private Adresse adresseDTO;
    private String telephone;
    private String motDePasse1;
    private String motDePasse2;
    private List<Chat> chatsProposes;

}