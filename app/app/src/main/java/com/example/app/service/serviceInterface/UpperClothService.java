package com.example.app.service.serviceInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.UpperClothRequestDTO;
import com.example.app.dto.responseDTO.UpperClothResponseDTO;

public interface UpperClothService {
    UpperClothResponseDTO create(UpperClothRequestDTO request, MultipartFile image) throws IOException;

    UpperClothResponseDTO update(Integer id, UpperClothRequestDTO request, MultipartFile image) throws IOException;

    void delete(Integer id);

    UpperClothResponseDTO getById(Integer id);

    List<UpperClothResponseDTO> getAll();
}