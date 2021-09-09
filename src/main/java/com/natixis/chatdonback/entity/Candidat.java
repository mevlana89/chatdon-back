package com.natixis.chatdonback.entity;

import javax.persistence.*;

@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeHebergement;

    private int surfaceHebergement;

    private boolean presenceJardin;

    private boolean sociableChat;

    private boolean sociableChien;

    // à voir : une liste d'age d'enfant
//    @OneToMany(mappedBy = "")
//    private List<AgeEnfant> ageEnfant = new ArrayList<>();

    //TODO à ajouter une fois la classe Candidature créée
//    @OneToMany(mappedBy = "")
//    List<Candidature> candidatures;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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
}
