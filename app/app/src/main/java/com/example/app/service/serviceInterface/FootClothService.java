package com.example.app.service.serviceInterface;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.FootClothRequestDTO;
import com.example.app.dto.responseDTO.FootClothResponseDTO;

public interface FootClothService {
    FootClothResponseDTO create(FootClothRequestDTO request, MultipartFile image) throws IOException;

    FootClothResponseDTO update(Integer id, FootClothRequestDTO request, MultipartFile image) throws IOException;

    void delete(Integer id);

    FootClothResponseDTO getById(Integer id);

    List<FootClothResponseDTO> getAll();

}