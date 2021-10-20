package com.natixis.chatdonback.dto;

import com.natixis.chatdonback.entity.Chat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class GetCandidatureDto {
    private int id;
    private Chat chat;
    private String status;
    private GetCandidatDto candidat;
}
