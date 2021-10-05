package com.natixis.chatdonback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CreateCandidatureDto {
    private int id;
    private int chatId;
    private String status;
}
