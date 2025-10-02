package com.example.app.dto.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.app.entity.Floor;
import com.example.app.dto.requestDTO.FloorDTORequest;
import com.example.app.dto.responseDTO.FloorDTOResponse;

@Mapper(componentModel = "spring")
public interface FloorMapper {

    Floor toEntity(FloorDTORequest request);

    FloorDTOResponse toResponse(Floor floor);

    List<FloorDTOResponse> toResponseList(List<Floor> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFloorFromDTO(FloorDTORequest dto, @MappingTarget Floor entity);

}
