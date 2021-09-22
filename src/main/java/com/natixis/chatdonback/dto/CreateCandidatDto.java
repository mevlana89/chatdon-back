package com.natixis.chatdonback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCandidatDto extends UtilisateurDTO
{
    private String typeHebergement;

    private int surfaceHebergement;

    private boolean presenceJardin;

    private boolean sociableChat;

    private boolean sociableChien;

    private int nbEnfant;

    private int ageBenjamin;

}
