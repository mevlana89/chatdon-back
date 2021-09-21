package com.natixis.chatdonback;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Donateur;
import com.natixis.chatdonback.mapper.DonateurMapper;

@SpringBootTest
class ChatdonBackApplicationTests {

	private DonateurMapper donateurMapper = Mappers.getMapper(DonateurMapper.class);
	
    @Test
    void contextLoads() {
    }

    @Test
    public void donateurEntityToDtoTest_WhenMapIsCorrect() {
    	
    	Donateur donateur = new Donateur();
    	donateur.setNom("donateur_nom");
    	donateur.setPrenom("donateur.prenom");
    	CreateDonateurDto createDonateurDto = donateurMapper.donateurEntityToDto(donateur);
    	Assert.assertEquals(donateur.getNom(), createDonateurDto.getNom());
    	Assert.assertEquals(donateur.getPrenom(), createDonateurDto.getPrenom());
    }
}
