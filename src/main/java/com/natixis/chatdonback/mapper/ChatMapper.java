package com.natixis.chatdonback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.natixis.chatdonback.dto.*;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.entity.Donateur;
import com.natixis.chatdonback.entity.PhotoChat;

public class ChatMapper {
    
    public static Chat updateChatDtoToEntity(UpdateChatDto chatDto) {
        Chat leChat = new Chat();
        leChat.setNom(chatDto.getNom());
        leChat.setCaractere(chatDto.getCaractere());
        leChat.setCategorieAge(chatDto.getCategorieAge());
        leChat.setDescriptif(chatDto.getDescriptif());
        if (chatDto.getDescriptif() != null) {
            System.out.println("descriptif non null, length : " + leChat.getDescriptif().length());
            if (leChat.getDescriptif().length() > 255) {
                leChat.setDescriptif(chatDto.getDescriptif().substring(0, 255));
            }
        }
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
        leChat.setLstPhotos(PhotoChatMapper.lstGetPhotoChatDtoToEntity(chatDto.getLstPhotos(), leChat));
        return leChat;
    }

    public static Chat createChatDtoToEntity(CreateChatDto chatDto) {
        Chat leChat = new Chat();
        leChat.setNom(chatDto.getNom());
        leChat.setCaractere(chatDto.getCaractere());
        leChat.setCategorieAge(chatDto.getCategorieAge());
        leChat.setDescriptif(chatDto.getDescriptif());
        if (chatDto.getDescriptif() != null) {
            System.out.println("descriptif non null, length : " + leChat.getDescriptif().length());
            if (leChat.getDescriptif().length() > 255) {
                leChat.setDescriptif(chatDto.getDescriptif().substring(0, 255));
            }
        }
        leChat.setSociableChat(chatDto.isSociableChat());
        leChat.setPelage(chatDto.getPelage());
        leChat.setRace(chatDto.getRace());
        leChat.setSexe(chatDto.getSexe());
        leChat.setSociableChien(chatDto.isSociableChien());
        leChat.setSociableEnfant(chatDto.isSociableEnfant());
        leChat.setTaille(chatDto.getTaille());
        leChat.setZoneGeo(chatDto.getZoneGeo());
        leChat.setDonateur(chatDto.getDonateur());
        System.out.println("createChatDtoToEntity");
        System.out.println("lstPhotos : " + chatDto.getLstPhotos().size());
        leChat.setLstPhotos(PhotoChatMapper.lstCreatePhotoChatDtoToEntity(chatDto.getLstPhotos(), leChat));
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
        chatDto.setDonateur(donateurEntityToGetChatDonateurDto(chat.getDonateur()));
        chatDto.setLstPhotos(PhotoChatMapper.lstEntityToGetPhotoChatDto(chat.getLstPhotos(), chatDto));
        return chatDto;
    };

    private static GetChatDonateurDto donateurEntityToGetChatDonateurDto(Donateur donateur) {
        return new GetChatDonateurDto(donateur.getId(), donateur.getNom(), donateur.getPrenom(), donateur.getMail());
    }

}
