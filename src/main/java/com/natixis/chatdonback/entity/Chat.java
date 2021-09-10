package com.natixis.chatdonback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }

    public String getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(String aCategorieAge) {
        categorieAge = aCategorieAge;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String aRace) {
        race = aRace;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String aSexe) {
        sexe = aSexe;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String aTaille) {
        taille = aTaille;
    }

    public String getPelage() {
        return pelage;
    }

    public void setPelage(String aPelage) {
        pelage = aPelage;
    }

    public String getCaractere() {
        return caractere;
    }

    public void setCaractere(String aCaractere) {
        caractere = aCaractere;
    }

    public String getZoneGeo() {
        return zoneGeo;
    }

    public void setZoneGeo(String aZoneGeo) {
        zoneGeo = aZoneGeo;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String aDescriptif) {
        descriptif = aDescriptif;
    }

    public boolean isSociableEnfant() {
        return sociableEnfant;
    }

    public void setSociableEnfant(boolean aSociableEnfant) {
        sociableEnfant = aSociableEnfant;
    }

    public boolean isSociableChat() {
        return sociableChat;
    }

    public void setSociableChat(boolean aSociableChat) {
        sociableChat = aSociableChat;
    }

    public boolean isSociableChien() {
        return sociableChien;
    }

    public void setSociableChien(boolean aSociableChien) {
        sociableChien = aSociableChien;
    }
    
    
    
    
    
}
