package com.natixis.chatdonback.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int chatId;
    private String status;

    @ManyToOne
    @JoinColumn(name = "chatId",insertable = false, updatable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "candidatId")
    private Candidat candidat;

}
