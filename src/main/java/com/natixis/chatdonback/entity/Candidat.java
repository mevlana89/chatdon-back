package com.natixis.chatdonback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class Candidat extends Utilisateur {

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

}
