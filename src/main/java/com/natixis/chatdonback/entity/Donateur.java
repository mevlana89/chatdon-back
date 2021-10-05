package com.natixis.chatdonback.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Slf4j
public class Donateur extends Utilisateur {
	
	 //TODO à ajouter une fois la classe CHATS créée
	 @OneToMany(mappedBy = "donateur", cascade = CascadeType.ALL)
	 private List<Chat> chatsProposes;
	
    void test1() {
        Donateur.log.debug("test");
    }
}
