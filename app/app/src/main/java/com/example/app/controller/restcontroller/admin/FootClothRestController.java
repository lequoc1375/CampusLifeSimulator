package com.example.app.controller.restcontroller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dto.requestDTO.FootClothRequestDTO;
import com.example.app.dto.responseDTO.FootClothResponseDTO;
import com.example.app.service.serviceInterface.FootClothService;

@RestController
@RequestMapping("/admin/api/footcloth")
public class FootClothRestController {

    @Autowired
    private FootClothService footClothService;

    @GetMapping
    public List<FootClothResponseDTO> getAll() {
        return footClothService.getAll();
    }

    @GetMapping("/{id}")
    public FootClothResponseDTO getById(@PathVariable int id) {
        return footClothService.getById(id);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<FootClothResponseDTO> create(
            @ModelAttribute FootClothRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        FootClothResponseDTO created = footClothService.create(request, image);
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<FootClothResponseDTO> update(
            @PathVariable int id,
            @ModelAttribute FootClothRequestDTO request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        FootClothResponseDTO updated = footClothService.update(id, request, image);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        footClothService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
