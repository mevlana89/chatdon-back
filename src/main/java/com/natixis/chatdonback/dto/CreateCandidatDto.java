package com.natixis.chatdonback.dto;

import java.util.List;

import com.natixis.chatdonback.entity.Candidature;
import com.natixis.chatdonback.entity.Chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCandidatDto extends UtilisateurDTO
{
    private String typeHebergement;

    private int surfaceHebergement;

    private boolean presenceJardin;

    private boolean sociableChat;

    private boolean sociableChien;

    private int ageBenjamin;
    
    //private List<Candidature> candidatures;

}
