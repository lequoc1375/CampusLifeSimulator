package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.requestDTO.GearAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.GearAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.GearAccessoriesService;

@RestController
@RequestMapping("/admin/api/gearaccessories")
public class GearAccessoriesRestController {

    @Autowired
    private GearAccessoriesService gearAccessoriesService;

    @GetMapping("/list")
    public List<GearAccessoriesResponseDTO> getAllGearAccessories() {
        return gearAccessoriesService.getAll();
    }

    @GetMapping("/{id}")
    public GearAccessoriesResponseDTO getGearAccessoriesById(@PathVariable Integer id) {
        return gearAccessoriesService.getById(id);
    }

    @PostMapping("/add")
    public void createGearAccessories(@RequestBody GearAccessoriesRequestDTO request) {
        gearAccessoriesService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateGearAccessories(@PathVariable Integer id, @RequestBody GearAccessoriesRequestDTO request) {
        gearAccessoriesService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGearAccessories(@PathVariable Integer id) {
        gearAccessoriesService.delete(id);
    }
}
