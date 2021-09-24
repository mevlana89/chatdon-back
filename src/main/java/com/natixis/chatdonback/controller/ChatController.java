package com.natixis.chatdonback.controller;

import com.natixis.chatdonback.dto.FilterDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.natixis.chatdonback.dto.CreateChatDto;
import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.service.ChatService;
import com.natixis.chatdonback.service.DonateurService;

@RestController
@CrossOrigin
public class ChatController {

    @Autowired
    ChatService chatService;
    
    @GetMapping("/getChatByID/{id}")
    public Chat getChatByID(@PathVariable int id){
        System.out.println("getChatById : " + id);
            try
            {

                return chatService.getChatById(id);
            } catch (Exception ex) {
                System.out.println("Exception getChaById : " + ex.getMessage());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chat non trouvé pour id "+id);
            }
    }

    @GetMapping("/chats/")
    public List <Chat> getAllUnreservedCats(FilterDto filterDto)
    {
        return chatService.findAllUnreservedCats(filterDto);
    }
    
    @Autowired
    DonateurService donateurService;
    
    @PostMapping("/createChat")
    public Chat createChat(@RequestBody CreateChatDto chatDto) {
        System.out.println("createChat");
        return chatService.createChat(chatDto);
    }
    
}
