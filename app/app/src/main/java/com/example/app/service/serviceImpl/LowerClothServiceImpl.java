package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.mapper.LowerClothMapper;
import com.example.app.dto.requestDTO.LowerClothRequestDTO;
import com.example.app.dto.responseDTO.CloudinaryResponseDTO;
import com.example.app.dto.responseDTO.LowerClothResponseDTO;
import com.example.app.entity.LowerCloth;
import com.example.app.repository.LowerClothRepo;
import com.example.app.service.serviceInterface.CloudinaryService;
import com.example.app.service.serviceInterface.LowerClothService;

@Service
public class LowerClothServiceImpl implements LowerClothService {

    @Autowired
    private LowerClothRepo lowerClothRepo;

    @Autowired
    private LowerClothMapper mapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public LowerClothResponseDTO create(LowerClothRequestDTO request, MultipartFile image) throws IOException {
        LowerCloth lowerCloth = mapper.toEntity(request);

        if (image != null && !image.isEmpty()) {
            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);
            lowerCloth.setImageUrl(uploadResult.getUrl());
            lowerCloth.setPublicId(uploadResult.getPublicId());
        }

        LowerCloth saved = lowerClothRepo.save(lowerCloth);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public LowerClothResponseDTO update(Integer id, LowerClothRequestDTO request, MultipartFile image) throws IOException {
        LowerCloth lowerCloth = lowerClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found lowerCloth"));

        lowerCloth.setCategories(request.getCategories());
        lowerCloth.setName(request.getName());
        lowerCloth.setPrice(request.getPrice());

        if (image != null && !image.isEmpty()) {
            // Xóa ảnh cũ nếu có
            if (lowerCloth.getPublicId() != null) {
                cloudinaryService.deleteFile(lowerCloth.getPublicId());
            }

            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);
            lowerCloth.setImageUrl(uploadResult.getUrl());
            lowerCloth.setPublicId(uploadResult.getPublicId());
        }

        LowerCloth updated = lowerClothRepo.save(lowerCloth);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void delete(Integer id) {
        LowerCloth lowerCloth = lowerClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found lowerCloth"));

        // Xóa ảnh Cloudinary trước
        if (lowerCloth.getPublicId() != null) {
            try {
                cloudinaryService.deleteFile(lowerCloth.getPublicId());
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete image from Cloudinary", e);
            }
        }

        lowerClothRepo.delete(lowerCloth);
    }

    @Override
    public LowerClothResponseDTO getById(Integer id) {
        LowerCloth lowerCloth = lowerClothRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return mapper.toResponseDTO(lowerCloth);
    }

    @Override
    public List<LowerClothResponseDTO> getAll() {
        return lowerClothRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
