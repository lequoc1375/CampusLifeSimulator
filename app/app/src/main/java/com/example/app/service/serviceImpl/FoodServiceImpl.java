package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.mapper.FoodMapper;
import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.CloudinaryResponseDTO;
import com.example.app.dto.responseDTO.FoodDTOResponse;
import com.example.app.entity.Food;
import com.example.app.repository.FoodRepo;
import com.example.app.service.serviceInterface.CloudinaryService;
import com.example.app.service.serviceInterface.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepo foodRepository;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public List<FoodDTOResponse> getAll() {
        return foodRepository.findAll().stream()
                .map(foodMapper::toFoodDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FoodDTOResponse getById(int id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        return foodMapper.toFoodDTO(food);
    }

    @Override
    public FoodDTOResponse create(FoodDTORequest request, MultipartFile image) throws IOException {
        Food food = foodMapper.toFood(request);

        if (image != null && !image.isEmpty()) {
            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);

            food.setImageUrl(uploadResult.getUrl());
            food.setPublicId(uploadResult.getPublicId());
        }

        Food saved = foodRepository.save(food);
        return foodMapper.toFoodDTO(saved);
    }

    @Override
    public FoodDTOResponse update(int id, FoodDTORequest request, MultipartFile image) throws IOException {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        food.setName(request.getName());
        food.setEnergyAffected(request.getEnergyAffected());
        food.setStressAffected(request.getStressAffected());
        food.setPrice(request.getPrice());
        food.setType(request.getType());
        food.setLivingRequirement(request.getLivingRequirement());

        if (image != null && !image.isEmpty()) {
            // Xóa ảnh cũ nếu có publicId
            if (food.getPublicId() != null) {
                cloudinaryService.deleteFile(food.getPublicId());
            }

            CloudinaryResponseDTO uploadResult = cloudinaryService.uploadFile(image);

            food.setImageUrl(uploadResult.getUrl());
            food.setPublicId(uploadResult.getPublicId());
        }

        Food updated = foodRepository.save(food);
        return foodMapper.toFoodDTO(updated);
    }

    @Override
    public void delete(int id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        // Xóa ảnh trên Cloudinary
        if (food.getPublicId() != null) {
            try {
                cloudinaryService.deleteFile(food.getPublicId());
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete image from Cloudinary", e);
            }
        }

        foodRepository.delete(food);
    }
}
