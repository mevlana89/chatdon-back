package com.natixis.chatdonback.service;

import java.util.List;
import java.util.Optional;

import com.natixis.chatdonback.dto.FilterDto;
import com.natixis.chatdonback.dto.UpdateChatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natixis.chatdonback.dto.CreateChatDto;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.mapper.ChatMapper;
import com.natixis.chatdonback.repository.ChatRepository;

@Service
public class ChatService {
    
    @Autowired
    private ChatRepository chatRepo;
    
    public Chat getChatById(int id) throws Exception {
        Optional<Chat> monChat = chatRepo.findById(id);
        if (monChat.isPresent()) {
            return monChat.get();
        }
        throw new Exception("not found");
    }

    public Chat createChat(CreateChatDto chatDto) {
        return chatRepo.save(ChatMapper.createChatDtoToEntity(chatDto));
    }
    
    public List<Chat> findAllUnreservedCats(FilterDto filterDto)
    {
        return chatRepo.findAll();
    }

    public Chat updateChat(UpdateChatDto chatDto) {
        return chatRepo.save(ChatMapper.updateChatDtoToEntity(chatDto));
    }
}
