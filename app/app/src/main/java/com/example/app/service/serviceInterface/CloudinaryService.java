package com.example.app.service.serviceInterface;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.responseDTO.CloudinaryResponseDTO;

public interface CloudinaryService {
    CloudinaryResponseDTO uploadFile(MultipartFile file) throws IOException;  

    void deleteFile(String publicId) throws IOException;       
}