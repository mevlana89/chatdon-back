package com.natixis.chatdonback.entity;

import javax.persistence.*;

@Entity
public class Candidat extends Utilisateur {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String typeHebergement;

    private int surfaceHebergement;

    private boolean presenceJardin;

    private boolean sociableChat;

    private boolean sociableChien;

    private int nbEnfant;

    private int ageBenjamin;

    //TODO à ajouter une fois la classe Candidature créée
//    @OneToMany(mappedBy = "")
//    List<Candidature> candidatures;

    public String getTypeHebergement() {
        return typeHebergement;
    }

    public void setTypeHebergement(String typeHebergement) {
        this.typeHebergement = typeHebergement;
    }

    public int getSurfaceHebergement() {
        return surfaceHebergement;
    }

    public void setSurfaceHebergement(int surface) {
        this.surfaceHebergement = surface;
    }

    public boolean isPresenceJardin() {
        return presenceJardin;
    }

    public void setPresenceJardin(boolean presenceJardin) {
        this.presenceJardin = presenceJardin;
    }

    public boolean isSociableChat() {
        return sociableChat;
    }

    public void setSociableChat(boolean sociableChat) {
        this.sociableChat = sociableChat;
    }

    public boolean isSociableChien() {
        return sociableChien;
    }

    public void setSociableChien(boolean sociableChien) {
        this.sociableChien = sociableChien;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }

    public int getAgeBenjamin() {
        return ageBenjamin;
    }

    public void setAgeBenjamin(int ageBenjamin) {
        this.ageBenjamin = ageBenjamin;
    }
}
