package com.natixis.chatdonback.service;

import java.util.*;

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
        Collection<Boolean> colSociableChat = new ArrayList<>();
        Collection<Boolean> colSociableChien = new ArrayList<>();
        Collection<Boolean> colSociableEnfant = new ArrayList<>();

        checkBoolean(filterDto.getSociableChat(), colSociableChat);
        checkBoolean(filterDto.getSociableChien(), colSociableChien);
        checkBoolean(filterDto.getSociableEnfant(), colSociableEnfant);

        return chatRepo.findAllByCategorieAgeContainingAndRaceContainingAndSexeContainingAndTailleContainingAndPelageContainingAndCaractereContainingAndSociableChatInAndSociableChienInAndSociableEnfantInAndZoneGeoContaining
                (filterDto.getCategorieAge(), filterDto.getRace(), filterDto.getSexe(), filterDto.getTaille(), filterDto.getPelage(), filterDto.getCaractere(), colSociableChat, colSociableChien, colSociableEnfant, filterDto.getZoneGeo());
    }

    private Collection<Boolean> checkBoolean(Boolean bool, Collection<Boolean> colBoolean) {
        if (bool == null)
        {
            colBoolean.add(true);
            colBoolean.add(false);
        }
        else {
            if (bool) {
                colBoolean.add(true);
            } else {
                colBoolean.add(false);
            }
        }
        return colBoolean;
    }

    public Chat updateChat(UpdateChatDto chatDto) {
        return chatRepo.save(ChatMapper.updateChatDtoToEntity(chatDto));
    }
}
