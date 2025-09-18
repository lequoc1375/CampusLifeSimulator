package com.example.app.controller.restcontroller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;
import com.example.app.service.serviceInterface.FoodService;

@RestController
@RequestMapping("/admin/api/food")
public class FoodRestController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<FoodDTOResponse> getAll() {
        return foodService.getAll();
    }

    @GetMapping("/{id}")
    public FoodDTOResponse getById(@PathVariable int id) {
        return foodService.getById(id);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<FoodDTOResponse> create(
            @ModelAttribute FoodDTORequest request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        FoodDTOResponse created = foodService.create(request, image);
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<FoodDTOResponse> update(
            @PathVariable int id,
            @ModelAttribute FoodDTORequest request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        FoodDTOResponse updated = foodService.update(id, request, image);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
