package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.mapper.FullClothMapper;
import com.example.app.dto.requestDTO.FullClothRequestDTO;
import com.example.app.dto.responseDTO.CloudinaryResponseDTO;
import com.example.app.dto.responseDTO.FullClothResponseDTO;
import com.example.app.entity.FullCloth;
import com.example.app.repository.FullClothRepo;
import com.example.app.service.serviceInterface.CloudinaryService;
import com.example.app.service.serviceInterface.FullClothService;

@Service
public class FullClothServiceImpl implements FullClothService {

    @Autowired
    private FullClothRepo fullClothRepo;

    @Autowired
    private FullClothMapper mapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public FullClothResponseDTO create(FullClothRequestDTO request, MultipartFile image) throws IOException {
        FullCloth fullCloth = mapper.toEntity(request);

        if (image != null && !image.isEmpty()) {
            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);
            fullCloth.setImageUrl(uploadResult.getUrl());
            fullCloth.setPublicId(uploadResult.getPublicId());
        }

        FullCloth saved = fullClothRepo.save(fullCloth);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public FullClothResponseDTO update(Integer id, FullClothRequestDTO request, MultipartFile image) throws IOException {
        FullCloth fullCloth = fullClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found FullCloth"));

        fullCloth.setCategories(request.getCategories());
        fullCloth.setName(request.getName());
        fullCloth.setPrice(request.getPrice());

        if (image != null && !image.isEmpty()) {
            // Xóa ảnh cũ nếu có
            if (fullCloth.getPublicId() != null) {
                cloudinaryService.deleteFile(fullCloth.getPublicId());
            }

            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);
            fullCloth.setImageUrl(uploadResult.getUrl());
            fullCloth.setPublicId(uploadResult.getPublicId());
        }

        FullCloth updated = fullClothRepo.save(fullCloth);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void delete(Integer id) {
        FullCloth fullCloth = fullClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found FullCloth"));

        // Xóa ảnh Cloudinary trước
        if (fullCloth.getPublicId() != null) {
            try {
                cloudinaryService.deleteFile(fullCloth.getPublicId());
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete image from Cloudinary", e);
            }
        }

        fullClothRepo.delete(fullCloth);
    }

    @Override
    public FullClothResponseDTO getById(Integer id) {
        FullCloth fullCloth = fullClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return mapper.toResponseDTO(fullCloth);
    }

    @Override
    public List<FullClothResponseDTO> getAll() {
        return fullClothRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}