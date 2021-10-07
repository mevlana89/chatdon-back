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
public class CreateDonateurDto extends UtilisateurDTO{

	private List<Chat> chatsProposes;
	
}