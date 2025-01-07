package com.project.main.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.project.main.Entity.Citizen;
import com.project.main.model.LoginRequestDTO;

@Mapper
public interface CitizenPopulator {
	
	CitizenPopulator INSTANCE = Mappers.getMapper(CitizenPopulator.class);

	Citizen populateCitizen(LoginRequestDTO loginRequestDTO);
}
