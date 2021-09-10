package com.natixis.chatdonback.dto;

import com.natixis.chatdonback.entity.Adresse;


public class CreateCandidatDto
{
    private String nom;

    private String prenom;

    private String mail;

    private Adresse adresse;

    private String telephone;

    private String motDePasse1;

    private String motDePasse2;

    private String typeHebergement;

    private int surfaceHebergement;

    private boolean presenceJardin;

    private boolean sociableChat;

    private boolean sociableChien;

    private int nbEnfant;

    private int ageBenjamin;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse1() {
        return motDePasse1;
    }

    public void setMotDePasse1(String motDePasse1) {
        this.motDePasse1 = motDePasse1;
    }

    public String getMotDePasse2() {
        return motDePasse2;
    }

    public void setMotDePasse2(String motDePasse2) {
        this.motDePasse2 = motDePasse2;
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

    public void setSurfaceHebergement(int surfaceHebergement) {
        this.surfaceHebergement = surfaceHebergement;
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
