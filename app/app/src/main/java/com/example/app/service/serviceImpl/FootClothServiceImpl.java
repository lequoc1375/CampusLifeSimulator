package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.mapper.FootClothMapper;
import com.example.app.dto.requestDTO.FootClothRequestDTO;
import com.example.app.dto.responseDTO.CloudinaryResponseDTO;
import com.example.app.dto.responseDTO.FootClothResponseDTO;
import com.example.app.entity.FootCloth;
import com.example.app.repository.FootClothRepo;
import com.example.app.service.serviceInterface.CloudinaryService;
import com.example.app.service.serviceInterface.FootClothService;

@Service
public class FootClothServiceImpl implements FootClothService {

    @Autowired
    private FootClothRepo footClothRepo;

    @Autowired
    private FootClothMapper mapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public FootClothResponseDTO create(FootClothRequestDTO request, MultipartFile image) throws IOException {
        FootCloth footCloth = mapper.toEntity(request);

        if (image != null && !image.isEmpty()) {
            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);
            footCloth.setImageUrl(uploadResult.getUrl());
            footCloth.setPublicId(uploadResult.getPublicId());
        }

        FootCloth saved = footClothRepo.save(footCloth);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public FootClothResponseDTO update(Integer id, FootClothRequestDTO request, MultipartFile image) throws IOException {
        FootCloth footCloth = footClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found FootCloth"));

        footCloth.setCategories(request.getCategories());
        footCloth.setName(request.getName());
        footCloth.setPrice(request.getPrice());

        if (image != null && !image.isEmpty()) {
            // Xóa ảnh cũ nếu có
            if (footCloth.getPublicId() != null) {
                cloudinaryService.deleteFile(footCloth.getPublicId());
            }

            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);
            footCloth.setImageUrl(uploadResult.getUrl());
            footCloth.setPublicId(uploadResult.getPublicId());
        }

        FootCloth updated = footClothRepo.save(footCloth);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void delete(Integer id) {
        FootCloth footCloth = footClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found FootCloth"));

        // Xóa ảnh Cloudinary trước
        if (footCloth.getPublicId() != null) {
            try {
                cloudinaryService.deleteFile(footCloth.getPublicId());
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete image from Cloudinary", e);
            }
        }

        footClothRepo.delete(footCloth);
    }

    @Override
    public FootClothResponseDTO getById(Integer id) {
        FootCloth footCloth = footClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return mapper.toResponseDTO(footCloth);
    }

    @Override
    public List<FootClothResponseDTO> getAll() {
        return footClothRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}