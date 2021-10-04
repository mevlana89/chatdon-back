package com.natixis.chatdonback;

<<<<<<< HEAD

=======
// import org.junit.Assert;
>>>>>>> ece8a6369703342c39c006c2ec08e4b0f3692373
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
<<<<<<< HEAD

=======
    	//Assert.assertEquals(donateur.getNom(), createDonateurDto.getNom());
    	//Assert.assertEquals(donateur.getPrenom(), createDonateurDto.getPrenom());
>>>>>>> ece8a6369703342c39c006c2ec08e4b0f3692373
    }
}
