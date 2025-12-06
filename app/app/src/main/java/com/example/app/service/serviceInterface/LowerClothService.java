package com.example.app.service.serviceInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.LowerClothRequestDTO;
import com.example.app.dto.responseDTO.LowerClothResponseDTO;

public interface LowerClothService {
    LowerClothResponseDTO create(LowerClothRequestDTO request, MultipartFile image) throws IOException;

    LowerClothResponseDTO update(Integer id, LowerClothRequestDTO request, MultipartFile image) throws IOException;

    void delete(Integer id);

    LowerClothResponseDTO getById(Integer id);

    List<LowerClothResponseDTO> getAll();
}