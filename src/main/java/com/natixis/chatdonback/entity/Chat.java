package com.natixis.chatdonback.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Slf4j
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nom;
    
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
    
    @OneToMany(mappedBy="chat", cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<PhotoChat> lstPhotos;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "donateur_id", nullable = false)
    @JsonBackReference
    private Donateur donateur;
    
    void test() {
        Chat.log.debug("trest");
    }
}