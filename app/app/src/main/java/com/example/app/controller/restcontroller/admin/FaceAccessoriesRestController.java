package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.requestDTO.FaceAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.FaceAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.FaceAccessoriesService;

@RestController
@RequestMapping("/admin/api/faceaccessories")
public class FaceAccessoriesRestController {

    @Autowired
    private FaceAccessoriesService faceAccessoriesService;

    @GetMapping("/list")
    public List<FaceAccessoriesResponseDTO> getAllFaceAccessories() {
        return faceAccessoriesService.getAll();
    }

    @GetMapping("/{id}")
    public FaceAccessoriesResponseDTO getFaceAccessoriesById(@PathVariable Integer id) {
        return faceAccessoriesService.getById(id);
    }

    @PostMapping("/add")
    public void createFaceAccessories(@RequestBody FaceAccessoriesRequestDTO request) {
        faceAccessoriesService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateFaceAccessories(@PathVariable Integer id, @RequestBody FaceAccessoriesRequestDTO request) {
        faceAccessoriesService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFaceAccessories(@PathVariable Integer id) {
        faceAccessoriesService.delete(id);
    }
}
