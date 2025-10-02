package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.requestDTO.FrontAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.FrontAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.FrontAccessoriesService;

@RestController
@RequestMapping("/admin/api/frontaccessories")
public class FrontAccessoriesRestController {

    @Autowired
    private FrontAccessoriesService frontAccessoriesService;

    @GetMapping("/list")
    public List<FrontAccessoriesResponseDTO> getAllFrontAccessories() {
        return frontAccessoriesService.getAll();
    }

    @GetMapping("/{id}")
    public FrontAccessoriesResponseDTO getFrontAccessoriesById(@PathVariable Integer id) {
        return frontAccessoriesService.getById(id);
    }

    @PostMapping("/add")
    public void createFrontAccessories(@RequestBody FrontAccessoriesRequestDTO request) {
        frontAccessoriesService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateFrontAccessories(@PathVariable Integer id, @RequestBody FrontAccessoriesRequestDTO request) {
        frontAccessoriesService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFrontAccessories(@PathVariable Integer id) {
        frontAccessoriesService.delete(id);
    }
}
