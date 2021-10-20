package com.natixis.chatdonback.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    //private int chatId;
    private String status;

    @ManyToOne
    @JoinColumn(name = "chat_id")
   // @JoinColumn(name = "chat_id",insertable = false, updatable = false)
    private Chat chat;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "candidat_id",nullable = false)
    private Candidat candidat;

}
