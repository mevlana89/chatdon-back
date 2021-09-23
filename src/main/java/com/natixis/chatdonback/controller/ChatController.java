package com.natixis.chatdonback.controller;

import java.util.ArrayList;
import java.util.List;

import com.natixis.chatdonback.dto.FilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.natixis.chatdonback.entity.Chat;
import com.natixis.chatdonback.entity.PhotoChat;
import com.natixis.chatdonback.service.ChatService;

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
                List<PhotoChat> lstPhotos = new ArrayList<>();
//                lstPhotos.add(new PhotoChat(1,1,"http://placekitten.com/300/200"));
//                lstPhotos.add(new PhotoChat(1,2,"http://placekitten.com/300/300"));
//                lstPhotos.add(new PhotoChat(1,3,"http://placekitten.com/250/250"));
                Chat leChat = new Chat( id,
                        "Minou",
                        "chaton", 
                        "birman", 
                        "male", 
                        "petit", 
                        "poil court", 
                        "calme", 
                        "ile de france", 
                        "chat gentil, aime jouer, dormir, manger, jouer, dormir, manger, jouer, dormir, manger, ", true, true, false,
                        lstPhotos);
                return leChat;
               // return chatService.getChatById(id);
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
    
}
