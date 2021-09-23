package com.natixis.chatdonback.service;

import java.util.List;
import java.util.Optional;

import com.natixis.chatdonback.dto.FilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natixis.chatdonback.entity.Chat;
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

    public List<Chat> findAllUnreservedCats(FilterDto filterDto)
    {
        return chatRepo.findAll();
    }
}
