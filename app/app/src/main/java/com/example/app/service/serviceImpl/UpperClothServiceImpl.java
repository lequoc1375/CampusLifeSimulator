package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.mapper.UpperClothMapper;
import com.example.app.dto.requestDTO.UpperClothRequestDTO;
import com.example.app.dto.responseDTO.CloudinaryResponseDTO;
import com.example.app.dto.responseDTO.UpperClothResponseDTO;
import com.example.app.entity.UpperCloth;
import com.example.app.repository.UpperClothRepo;
import com.example.app.service.serviceInterface.CloudinaryService;
import com.example.app.service.serviceInterface.UpperClothService;

@Service
public class UpperClothServiceImpl implements UpperClothService {

    @Autowired
    private UpperClothRepo upperClothRepo;

    @Autowired
    private UpperClothMapper mapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public UpperClothResponseDTO create(UpperClothRequestDTO request, MultipartFile image) throws IOException {
        UpperCloth upperCloth = mapper.toEntity(request);

        if (image != null && !image.isEmpty()) {
            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);
            upperCloth.setImageUrl(uploadResult.getUrl());
            upperCloth.setPublicId(uploadResult.getPublicId());
        }

        return mapper.toResponseDTO(upperClothRepo.save(upperCloth));
    }

    @Override
    public UpperClothResponseDTO update(Integer id, UpperClothRequestDTO request, MultipartFile image) throws IOException {
        UpperCloth upperCloth = upperClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("UpperCloth not found"));

        // Cập nhật các field cơ bản
        upperCloth.setCategories(request.getCategories());
        upperCloth.setName(request.getName());
        upperCloth.setPrice(request.getPrice());

        // Xử lý ảnh
        if (image != null && !image.isEmpty()) {
            if (upperCloth.getPublicId() != null) {
                cloudinaryService.deleteFile(upperCloth.getPublicId());
            }

            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);
            upperCloth.setImageUrl(uploadResult.getUrl());
            upperCloth.setPublicId(uploadResult.getPublicId());
        }

        return mapper.toResponseDTO(upperClothRepo.save(upperCloth));
    }

    @Override
    public void delete(Integer id) {
        UpperCloth upperCloth = upperClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("UpperCloth not found"));

        if (upperCloth.getPublicId() != null) {
            try {
                cloudinaryService.deleteFile(upperCloth.getPublicId());
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete image from Cloudinary", e);
            }
        }

        upperClothRepo.delete(upperCloth);
    }

    @Override
    public UpperClothResponseDTO getById(Integer id) {
        return mapper.toResponseDTO(
                upperClothRepo.findById(id)
                        .orElseThrow(() -> new RuntimeException("UpperCloth not found"))
        );
    }

    @Override
    public List<UpperClothResponseDTO> getAll() {
        return upperClothRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
