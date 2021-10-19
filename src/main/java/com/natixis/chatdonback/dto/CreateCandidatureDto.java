package com.natixis.chatdonback.dto;

import com.natixis.chatdonback.entity.Chat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CreateCandidatureDto {
    private int id;
    private int chatId;
    private Chat chat;
    private String status="En cours";
}
