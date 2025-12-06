package com.example.app.controller.restcontroller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.GymExerciseDTORequest;
import com.example.app.dto.responseDTO.GymExerciseDTOResponse;
import com.example.app.service.serviceInterface.GymExerciseService;

@RestController
@RequestMapping("/admin/api/gym/exercise")
public class GymExerciseRestController {

    @Autowired
    private GymExerciseService gymExerciseService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<GymExerciseDTOResponse> create(
            @ModelAttribute GymExerciseDTORequest request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        GymExerciseDTOResponse created = gymExerciseService.create(request, image);
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<GymExerciseDTOResponse> update(
            @PathVariable int id,
            @ModelAttribute GymExerciseDTORequest request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        GymExerciseDTOResponse updated = gymExerciseService.update(id, request, image);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws IOException {
        gymExerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<GymExerciseDTOResponse> getAll() {
        return gymExerciseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymExerciseDTOResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(gymExerciseService.getById(id));
    }
}
