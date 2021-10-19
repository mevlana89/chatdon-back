package com.natixis.chatdonback.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private String cheminPhoto;

    @JsonBackReference
    private GetChatDto chat;

}
