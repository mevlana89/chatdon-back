package com.natixis.chatdonback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.service.ChatService;

@Controller
public class ChatController {

    @Autowired
    ChatService chatService;
    
    @GetMapping("/getChatByID/{id}")
    public Chat getChatByID(@PathVariable int id){
            try
            {
                return chatService.getChatById(id);
            } catch (Exception ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chat non trouvé pour id "+id);
            }
    }
    
}
