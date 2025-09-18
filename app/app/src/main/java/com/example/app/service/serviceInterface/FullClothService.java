package com.example.app.service.serviceInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.FullClothRequestDTO;
import com.example.app.dto.responseDTO.FullClothResponseDTO;

public interface FullClothService {
    FullClothResponseDTO create(FullClothRequestDTO request, MultipartFile image) throws IOException;

    FullClothResponseDTO update(Integer id, FullClothRequestDTO request, MultipartFile image) throws IOException;

    void delete(Integer id);

    FullClothResponseDTO getById(Integer id);

    List<FullClothResponseDTO> getAll();

}
