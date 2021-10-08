package com.natixis.chatdonback.mapper;

import com.natixis.chatdonback.dto.CreatePhotoChatDto;
import com.natixis.chatdonback.dto.GetChatDto;
import com.natixis.chatdonback.dto.GetPhotoChatDto;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.entity.PhotoChat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PhotoChatMapper {

    public static ArrayList<PhotoChat> lstPhotoChatDtoToEntity(List<CreatePhotoChatDto> lstPhotoChatDto, Chat chat)
    {
        ArrayList<PhotoChat> lstPhotosChat = new ArrayList<PhotoChat>();
        for (CreatePhotoChatDto cphotoDto : lstPhotoChatDto) {
            lstPhotosChat.add(createPhotoChatDtoToPhotoChat(cphotoDto, chat));
        }
        return lstPhotosChat;
    }

    private static PhotoChat createPhotoChatDtoToPhotoChat(CreatePhotoChatDto createPhotoChatDto, Chat chat) {
        if ( createPhotoChatDto == null && chat == null ) {
            return null;
        }
        PhotoChat photoChat = new PhotoChat();
        photoChat.setChat(chat);
        photoChat.setCheminPhoto(createPhotoChatDto.getCheminPhoto());
        return photoChat;
    }

    public static ArrayList<PhotoChat> lstGetPhotoChatDtoToEntity(List<GetPhotoChatDto> lstPhotoChatDto, Chat chat)
    {
        ArrayList<PhotoChat> lstPhotosChat = new ArrayList<PhotoChat>();
        for (GetPhotoChatDto cphotoDto : lstPhotoChatDto) {
            lstPhotosChat.add(getPhotoChatDtoToPhotoChat(cphotoDto, chat));
        }
        return lstPhotosChat;
    }

    private static PhotoChat getPhotoChatDtoToPhotoChat(GetPhotoChatDto getPhotoChatDto, Chat chat) {
        if ( getPhotoChatDto == null && chat == null ) {
            return null;
        }
        return new PhotoChat(getPhotoChatDto.getId(), chat, getPhotoChatDto.getCheminPhoto());
    }

    public static ArrayList<GetPhotoChatDto> lstEntityToGetPhotoChatDto(List<PhotoChat> lstPhotoChat, GetChatDto chatDto)
    {
        if (lstPhotoChat == null || chatDto == null ) {
            return null;
        }
        ArrayList<GetPhotoChatDto> lstGetPhotoChatDto = new ArrayList<>();
        for (PhotoChat photo : lstPhotoChat) {
            lstGetPhotoChatDto.add(getEntityToGetPhotoChatDto(photo, chatDto));
        }
        return lstGetPhotoChatDto;
    }

    private static GetPhotoChatDto getEntityToGetPhotoChatDto(PhotoChat photo, GetChatDto chatDto) {
        return new GetPhotoChatDto(photo.getId(), chatDto, photo.getCheminPhoto());
    }
}
