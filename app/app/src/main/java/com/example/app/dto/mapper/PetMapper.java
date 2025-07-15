package com.example.app.dto.mapper;

import org.mapstruct.Mapper;
import com.example.app.entity.Pet;
import com.example.app.dto.requestDTO.PetDTORequest;
import com.example.app.dto.responseDTO.PetDTOResponse;

@Mapper(componentModel = "spring")
public interface PetMapper {
    Pet toPet(PetDTORequest dto);

    PetDTOResponse toPetDTO(Pet pet);
}
