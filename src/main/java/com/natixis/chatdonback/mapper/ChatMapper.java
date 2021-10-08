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
    
    public static Chat updateChatDtoToEntity(UpdateChatDto chatDto) {
        Chat leChat = new Chat();
        leChat.setNom(chatDto.getNom());
        leChat.setCaractere(chatDto.getCaractere());
        leChat.setCategorieAge(chatDto.getCategorieAge());
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
        leChat.setDonateur(chatDto.getDonateur());
        leChat.setLstPhotos(PhotoChatMapper.lstPhotoChatDtoToEntity(chatDto.getLstPhotos(), leChat));
        return leChat;
    }

    public static Chat createChatDtoToEntity(CreateChatDto chatDto) {
        Chat leChat = new Chat();
        leChat.setNom(chatDto.getNom());
        leChat.setCaractere(chatDto.getCaractere());
        leChat.setCategorieAge(chatDto.getCategorieAge());
        leChat.setDescriptif(chatDto.getDescriptif());
        leChat.setSociableChat(chatDto.isSociableChat());
        leChat.setPelage(chatDto.getPelage());
        leChat.setRace(chatDto.getRace());
        leChat.setSexe(chatDto.getSexe());
        leChat.setSociableChien(chatDto.isSociableChien());
        leChat.setSociableEnfant(chatDto.isSociableEnfant());
        leChat.setTaille(chatDto.getTaille());
        leChat.setZoneGeo(chatDto.getZoneGeo());
        leChat.setDonateur(chatDto.getDonateur());
        leChat.setLstPhotos(PhotoChatMapper.lstPhotoChatDtoToEntity(chatDto.getLstPhotos(), leChat));
        return leChat;
    }

    public static GetChatDto chatEntityToDto(Chat chat) {
        GetChatDto chatDto = new GetChatDto();
        chatDto.setNom(chat.getNom());
        chatDto.setCaractere(chat.getCaractere());
        chatDto.setCategorieAge(chat.getCategorieAge());
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
        chatDto.setDonateur(chat.getDonateur());
        chatDto.setLstGetPhotoChatDto(PhotoChatMapper.lstEntityToGetPhotoChatDto(chat.getLstPhotos(), chatDto));
        return chatDto;
    };
 

     
}
