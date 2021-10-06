package com.natixis.chatdonback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.natixis.chatdonback.dto.CreateChatDto;
import com.natixis.chatdonback.dto.CreatePhotoChatDto;
import com.natixis.chatdonback.dto.GetChatDto;
import com.natixis.chatdonback.dto.UpdateChatDto;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.entity.PhotoChat;

public class ChatMapper {
    
//    @Mapping(target = "id", ignore = true)
//    @Mapping(expression="java(lstPhotoChatDtoToEntity(chatDto.getLstPhotos(), chat))", target = "lstPhotos")
    public static Chat updateChatDtoToEntity(UpdateChatDto chatDto) {
        Chat leChat = new Chat();
        leChat.setCaractere(chatDto.getCaractere());
        leChat.setCategorieAge(chatDto.getCaractere());
        leChat.setDescriptif(chatDto.getDescriptif());
        leChat.setSociableChat(chatDto.isSociableChat());
        leChat.setId(chatDto.getId());
        leChat.setPelage(chatDto.getPelage());
        leChat.setRace(chatDto.getRace());
        leChat.setSexe(chatDto.getSexe());
        leChat.setSociableChien(chatDto.isSociableChien());
        leChat.setSociableEnfant(chatDto.isSociableEnfant());
        leChat.setTaille(chatDto.getTaille());
        leChat.setZoneGeo(chatDto.getZoneGeo());
        return leChat;
    }

    public static Chat createChatDtoToEntity(CreateChatDto chatDto) {
        Chat leChat = new Chat();
        leChat.setCaractere(chatDto.getCaractere());
        leChat.setCategorieAge(chatDto.getCaractere());
        leChat.setDescriptif(chatDto.getDescriptif());
        leChat.setSociableChat(chatDto.isSociableChat());
        leChat.setPelage(chatDto.getPelage());
        leChat.setRace(chatDto.getRace());
        leChat.setSexe(chatDto.getSexe());
        leChat.setSociableChien(chatDto.isSociableChien());
        leChat.setSociableEnfant(chatDto.isSociableEnfant());
        leChat.setTaille(chatDto.getTaille());
        leChat.setZoneGeo(chatDto.getZoneGeo());
        return leChat;
    }

    public static GetChatDto chatEntityToDto(Chat chat) {
        GetChatDto chatDto = new GetChatDto();
        chatDto.setCaractere(chat.getCaractere());
        chatDto.setCategorieAge(chat.getCaractere());
        chatDto.setDescriptif(chat.getDescriptif());
        chatDto.setSociableChat(chat.isSociableChat());
        chatDto.setId(chat.getId());
        chatDto.setPelage(chat.getPelage());
        chatDto.setRace(chat.getRace());
        chatDto.setSexe(chat.getSexe());
        chatDto.setSociableChien(chat.isSociableChien());
        chatDto.setSociableEnfant(chat.isSociableEnfant());
        chatDto.setTaille(chat.getTaille());
        chatDto.setZoneGeo(chat.getZoneGeo());
        return chatDto;
    };
 
    public static ArrayList<PhotoChat> lstPhotoChatDtoToEntity(List<CreatePhotoChatDto> lstPhotoChatDto, Chat chat)
    {
        ArrayList<PhotoChat> lstPhotosChat = new ArrayList<PhotoChat>();
        for (CreatePhotoChatDto cphotoDto : lstPhotoChatDto) {
            lstPhotosChat.add(createPhotoChatDtoToPhotoChat(cphotoDto, chat));
        }
        return lstPhotosChat;
    }
     
 //   @Mapping(source="chat", target="chat")
 //   @Mapping(target = "id", ignore = true)
    public static PhotoChat createPhotoChatDtoToPhotoChat(CreatePhotoChatDto createPhotoChatDto, Chat chat) {
        if ( createPhotoChatDto == null && chat == null ) {
            return null;
        }
        PhotoChat photoChat = new PhotoChat();
        photoChat.setChat(chat);
        photoChat.setCheminPhoto(createPhotoChatDto.getCheminPhoto());
        return photoChat;
    }
     
}
