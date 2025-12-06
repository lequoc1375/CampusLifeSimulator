package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;
import com.example.app.entity.Food;
import com.example.app.dto.mapper.FoodMapper;
import com.example.app.repository.FoodRepo;
import com.example.app.service.serviceInterface.FoodService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepo foodRepository;
    private final FoodMapper mapper;
    private final Cloudinary cloudinary;

    @Override
    public FoodDTOResponse create(FoodDTORequest dto, MultipartFile image) throws IOException {
        Food food = mapper.toEntity(dto);

        if (image != null && !image.isEmpty()) {
            Map upload = cloudinary.uploader().upload(image.getBytes(), Map.of());
            food.setImageUrl(upload.get("secure_url").toString());
            food.setPublicId(upload.get("public_id").toString());
        }

        return mapper.toResponseDTO(foodRepository.save(food));
    }

    @Override
    public FoodDTOResponse update(Integer id, FoodDTORequest dto, MultipartFile image) throws IOException {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        food.setName(dto.getName());
        food.setEnergyAffected(dto.getEnergyAffected());
        food.setStressAffected(dto.getStressAffected());
        food.setPrice(dto.getPrice());
        food.setType(dto.getType());
        food.setLivingRequirement(dto.getLivingRequirement());

        if (image != null && !image.isEmpty()) {

            // Delete old image if exists
            if (food.getPublicId() != null) {
                cloudinary.uploader().destroy(food.getPublicId(), Map.of());
            }

            // Upload new image
            Map upload = cloudinary.uploader().upload(image.getBytes(), Map.of());
            food.setImageUrl(upload.get("secure_url").toString());
            food.setPublicId(upload.get("public_id").toString());
        }

        return mapper.toResponseDTO(foodRepository.save(food));
    }

    @Override
    public void delete(Integer id) throws IOException {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        if (food.getPublicId() != null) {
            cloudinary.uploader().destroy(food.getPublicId(), Map.of());
        }

        foodRepository.delete(food);
    }

    @Override
    public List<FoodDTOResponse> getAll() {
        return foodRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FoodDTOResponse getById(Integer id) {
        return foodRepository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    public List<FoodDTOResponse> getFoodByType(String type) {
        return foodRepository.findAll().stream()
                .filter(food -> food.getType() != null && food.getType().equalsIgnoreCase(type))
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}