package com.natixis.chatdonback.controller;

import com.natixis.chatdonback.dto.*;

import java.util.List;

import com.natixis.chatdonback.entity.Candidature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.service.ChatService;

@RestController
@CrossOrigin
public class ChatController {

    @Autowired
    ChatService chatService;
    
    @GetMapping("/getChatByID/{id}")
    public GetChatDto getChatByID(@PathVariable int id){
        System.out.println("getChatById : " + id);
            try
            {
                return chatService.getChatDtoById(id);
            } catch (Exception ex) {
                System.out.println("Exception getChaById : " + ex.getMessage());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chat non trouvé pour id "+id);
            }
    }

    @GetMapping("/chats")
    public List <Chat> getAllUnreservedCats(FilterDto filterDto)
    {
        return chatService.findAllUnreservedCats(filterDto);
    }
    
    @PostMapping("/createChat")
    public Chat createChat(@RequestBody CreateChatDto chatDto) {
        System.out.println("createChat");
        return chatService.createChat(chatDto);
    }

    @PostMapping("/updateChat")
    public Chat updateChat(@RequestBody UpdateChatDto chatDto) {
        System.out.println("updateChat");

        return chatService.updateChat(chatDto);
    }

    @GetMapping("/chats/{id}/candidatures")
    public List <Candidature> getAllCandidaturesByCatId(@PathVariable int id)
    {
        return chatService.findAllCandidaturesByCatId(id);
    }

    @GetMapping("/chats/{id}/candidaturesDto")
    public List <CreateCandidatureDto> getAllCreateCandidaturesDtoByCatId(@PathVariable int id)
    {
        return chatService.findAllCreateCandidaturesDtoByCatId(id);
    }

    @PostMapping("/deleteChatById/{id}")
    public boolean deleteChatById(@PathVariable int id)
    {
        System.out.println("delete ChatBy Id : " + id);
        return chatService.deleteChatById(id);
    }
}
