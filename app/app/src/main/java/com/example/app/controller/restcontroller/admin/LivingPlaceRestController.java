package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.requestDTO.LivingPlaceRequestDTO;
import com.example.app.dto.responseDTO.LivingPlaceResponseDTO;
import com.example.app.service.serviceInterface.LivingPlaceService;

@RestController
@RequestMapping("/admin/api/livingplace")
public class LivingPlaceRestController {

    @Autowired
    private LivingPlaceService livingPlaceService;

    @GetMapping("/list")
    public List<LivingPlaceResponseDTO> getAllLivingPlaces() {
        return livingPlaceService.getAll();
    }

    @GetMapping("/{id}")
    public LivingPlaceResponseDTO getLivingPlaceById(@PathVariable Integer id) {
        return livingPlaceService.getById(id);
    }

    @PostMapping("/add")
    public void createLivingPlace(@RequestBody LivingPlaceRequestDTO request) {
        livingPlaceService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateLivingPlace(@PathVariable Integer id, @RequestBody LivingPlaceRequestDTO request) {
        livingPlaceService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLivingPlace(@PathVariable Integer id) {
        livingPlaceService.delete(id);
    }
}
