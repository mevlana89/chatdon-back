package com.natixis.chatdonback.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Donateur extends Utilisateur {
	
	// TODO à ajouter une fois la classe CHATS créée
	// @OneToMany(mappedBy = "donateur", cascade = CascadeType.ALL)
	// private List<Chats> chatsProposes;

	// à supp
	private String test;
	
}
