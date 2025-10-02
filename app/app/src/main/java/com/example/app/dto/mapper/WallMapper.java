package com.example.app.dto.mapper;

import com.example.app.dto.requestDTO.*;
import com.example.app.dto.responseDTO.*;
import com.example.app.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface WallMapper {
    Wall toEntity(WallDTORequest dto);

    WallDTOResponse toResponse(Wall entity);
}
