package com.example.app.service.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.app.dto.mapper.GymExerciseMapper;
import com.example.app.dto.requestDTO.GymExerciseDTORequest;
import com.example.app.dto.responseDTO.GymExerciseDTOResponse;
import com.example.app.entity.GymExercise;
import com.example.app.repository.GymExerciseRepo;
import com.example.app.service.serviceInterface.GymExerciseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GymExerciseServiceImpl implements GymExerciseService {

    private final GymExerciseRepo gymExerciseRepo;
    private final GymExerciseMapper mapper;
    private final Cloudinary cloudinary;

    // ✅ CREATE
    @Override
    public GymExerciseDTOResponse create(GymExerciseDTORequest dto, MultipartFile image) throws IOException {
        GymExercise exercise = mapper.toEntity(dto);

        if (image != null && !image.isEmpty()) {
            Map upload = cloudinary.uploader().upload(image.getBytes(), Map.of());
            exercise.setImageUrl(upload.get("secure_url").toString());
            exercise.setPublicId(upload.get("public_id").toString());
        }

        return mapper.toResponseDTO(gymExerciseRepo.save(exercise));
    }

    // ✅ UPDATE
    @Override
    public GymExerciseDTOResponse update(Integer id, GymExerciseDTORequest dto, MultipartFile image) throws IOException {
        GymExercise exercise = gymExerciseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        exercise.setName(dto.getName());
        exercise.setEnergyCost(dto.getEnergyCost());
        exercise.setStressIncrease(dto.getStressIncrease());
        exercise.setExpReward(dto.getExpReward());

        if (image != null && !image.isEmpty()) {

            // ✅ Delete old image
            if (exercise.getPublicId() != null) {
                cloudinary.uploader().destroy(exercise.getPublicId(), Map.of());
            }

            // ✅ Upload new image
            Map upload = cloudinary.uploader().upload(image.getBytes(), Map.of());
            exercise.setImageUrl(upload.get("secure_url").toString());
            exercise.setPublicId(upload.get("public_id").toString());
        }

        return mapper.toResponseDTO(gymExerciseRepo.save(exercise));
    }

    // ✅ DELETE
    @Override
    public void delete(Integer id) throws IOException {
        GymExercise exercise = gymExerciseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        if (exercise.getPublicId() != null) {
            cloudinary.uploader().destroy(exercise.getPublicId(), Map.of());
        }

        gymExerciseRepo.delete(exercise);
    }

    // ✅ GET ALL
    @Override
    public List<GymExerciseDTOResponse> getAll() {
        return gymExerciseRepo.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // ✅ GET BY ID
    @Override
    public GymExerciseDTOResponse getById(Integer id) {
        return gymExerciseRepo.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
    }
}
