package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.requestDTO.BackAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.BackAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.BackAccessoriesService;

@RestController
@RequestMapping("/admin/api/backaccessories")
public class BackAccessoriesRestController {

    @Autowired
    private BackAccessoriesService backAccessoriesService;

    @GetMapping("/list")
    public List<BackAccessoriesResponseDTO> getAllBackAccessories() {
        return backAccessoriesService.getAll();
    }

    @GetMapping("/{id}")
    public BackAccessoriesResponseDTO getBackAccessoriesById(@PathVariable Integer id) {
        return backAccessoriesService.getById(id);
    }

    @PostMapping("/add")
    public void createBackAccessories(@RequestBody BackAccessoriesRequestDTO request) {
        backAccessoriesService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateBackAccessories(@PathVariable Integer id, @RequestBody BackAccessoriesRequestDTO request) {
        backAccessoriesService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBackAccessories(@PathVariable Integer id) {
        backAccessoriesService.delete(id);
    }
}
