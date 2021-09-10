package com.natixis.chatdonback.mapper;

import org.mapstruct.Mapper;

import com.natixis.chatdonback.dto.CreateDonateurDto;
import com.natixis.chatdonback.entity.Donateur;

@Mapper
public interface DonateurMapper {
	
	public Donateur donateurDtoToEntity(CreateDonateurDto createDonateurDto);
	public CreateDonateurDto donateurEntityToDto(Donateur donateur);

}
