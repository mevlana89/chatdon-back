package com.natixis.chatdonback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter @Setter @NoArgsConstructor
@Slf4j
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String categorieAge;
    
    private String race;
    
    private String sexe;
    
    private String taille;
    
    private String pelage;
    
    private String caractere;
    
    private String zoneGeo;
    
    private String descriptif;
    
    private boolean sociableEnfant;
    
    private boolean sociableChat;
    
    private boolean sociableChien;
    
}
