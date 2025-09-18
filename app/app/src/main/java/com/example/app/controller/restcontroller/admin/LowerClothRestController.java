package com.example.app.controller.restcontroller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.LowerClothRequestDTO;
import com.example.app.dto.responseDTO.LowerClothResponseDTO;
import com.example.app.service.serviceInterface.LowerClothService;

@RestController
@RequestMapping("/admin/api/lowercloth")
public class LowerClothRestController {

    @Autowired
    private LowerClothService lowerClothService;

    @GetMapping
    public List<LowerClothResponseDTO> getAll() {
        return lowerClothService.getAll();
    }

    @GetMapping("/{id}")
    public LowerClothResponseDTO getById(@PathVariable int id) {
        return lowerClothService.getById(id);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<LowerClothResponseDTO> create(
            @ModelAttribute LowerClothRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        LowerClothResponseDTO created = lowerClothService.create(request, image);
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<LowerClothResponseDTO> update(
            @PathVariable int id,
            @ModelAttribute LowerClothRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        LowerClothResponseDTO updated = lowerClothService.update(id, request, image);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        lowerClothService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
