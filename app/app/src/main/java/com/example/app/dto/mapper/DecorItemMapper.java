package com.example.app.dto.mapper;

import com.example.app.dto.requestDTO.DecorItemDTORequest;
import com.example.app.dto.responseDTO.DecorItemDTOResponse;
import com.example.app.entity.DecorItem;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DecorItemMapper {

    DecorItem toEntity(DecorItemDTORequest dto);

    DecorItemDTOResponse toResponse(DecorItem entity);

    List<DecorItemDTOResponse> toResponseList(List<DecorItem> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDecorItemFromDTO(DecorItemDTORequest dto, @MappingTarget DecorItem entity);
}
