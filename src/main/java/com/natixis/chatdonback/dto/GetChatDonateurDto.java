package com.natixis.chatdonback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetChatDonateurDto {

    private Long id;

    private String nom;

    private String prenom;

    private String mail;

}
