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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.requestDTO.UpperClothRequestDTO;
import com.example.app.dto.responseDTO.FoodDTOResponse;
import com.example.app.dto.responseDTO.UpperClothResponseDTO;
import com.example.app.service.serviceInterface.FoodService;

@RestController
@RequestMapping("/admin/api/food")
public class FoodRestController {

    @Autowired
    private FoodService foodService;

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
    public ResponseEntity<Void> delete(@PathVariable int id) throws IOException {
        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<FoodDTOResponse> getAll() {
        return foodService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDTOResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(foodService.getById(id));
    }
}
