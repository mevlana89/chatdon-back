package com.natixis.chatdonback.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.natixis.chatdonback.dto.CreateChatDto;
import com.natixis.chatdonback.dto.CreatePhotoChatDto;
import com.natixis.chatdonback.dto.GetChatDto;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.entity.PhotoChat;

@Mapper
public interface ChatMapper {
    
    final ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(expression="java(lstPhotoChatDtoToEntity(chatDto.getLstPhotos(), chat))", target = "lstPhotos")
    public Chat chatDtoToEntity(CreateChatDto chatDto); 
    
    public GetChatDto chatEntityToDto(Chat chat);
 
     default ArrayList<PhotoChat> lstPhotoChatDtoToEntity(List<CreatePhotoChatDto> lstPhotoChatDto, Chat chat) 
   {
        ArrayList<PhotoChat> lstPhotosChat = new ArrayList<PhotoChat>();
        for (CreatePhotoChatDto cphotoDto : lstPhotoChatDto) {
            lstPhotosChat.add(createPhotoChatDtoToPhotoChat(cphotoDto, chat));
        }
        return lstPhotosChat;
    }
     
     @Mapping(source="chat", target="chat")
     @Mapping(target = "id", ignore = true)
     PhotoChat createPhotoChatDtoToPhotoChat(CreatePhotoChatDto createPhotoChatDto, Chat chat); 
     
}
