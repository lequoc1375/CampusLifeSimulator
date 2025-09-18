package com.example.app.controller.restcontroller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.UpperClothRequestDTO;
import com.example.app.dto.responseDTO.UpperClothResponseDTO;
import com.example.app.service.serviceInterface.UpperClothService;

@RestController
@RequestMapping("/admin/api/uppercloth")
public class UpperClothRestController {

    @Autowired
    private UpperClothService upperClothService;

    @GetMapping
    public List<UpperClothResponseDTO> getAll() {
        return upperClothService.getAll();
    }

    @GetMapping("/{id}")
    public UpperClothResponseDTO getById(@PathVariable int id) {
        return upperClothService.getById(id);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<UpperClothResponseDTO> create(
            @ModelAttribute UpperClothRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        UpperClothResponseDTO created = upperClothService.create(request, image);
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<UpperClothResponseDTO> update(
            @PathVariable int id,
            @ModelAttribute UpperClothRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        UpperClothResponseDTO updated = upperClothService.update(id, request, image);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        upperClothService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
