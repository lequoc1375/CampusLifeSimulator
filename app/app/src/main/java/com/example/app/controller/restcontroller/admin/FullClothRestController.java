package com.example.app.controller.restcontroller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.FullClothRequestDTO;
import com.example.app.dto.responseDTO.FullClothResponseDTO;
import com.example.app.service.serviceInterface.FullClothService;

@RestController
@RequestMapping("/admin/api/fullcloth")
public class FullClothRestController {

    @Autowired
    private FullClothService fullClothService;

    @GetMapping
    public List<FullClothResponseDTO> getAll() {
        return fullClothService.getAll();
    }

    @GetMapping("/{id}")
    public FullClothResponseDTO getById(@PathVariable int id) {
        return fullClothService.getById(id);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<FullClothResponseDTO> create(
            @ModelAttribute FullClothRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        FullClothResponseDTO created = fullClothService.create(request, image);
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<FullClothResponseDTO> update(
            @PathVariable int id,
            @ModelAttribute FullClothRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        FullClothResponseDTO updated = fullClothService.update(id, request, image);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        fullClothService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
