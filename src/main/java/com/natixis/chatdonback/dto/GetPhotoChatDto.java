package com.natixis.chatdonback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPhotoChatDto {

    private int id;
    private GetChatDto chat;
    private String cheminPhoto;

}
