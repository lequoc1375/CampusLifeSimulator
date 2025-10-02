package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.requestDTO.HeadAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.HeadAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.HeadAccessoriesService;

@RestController
@RequestMapping("/admin/api/headaccessories")
public class HeadAccessoriesRestController {

    @Autowired
    private HeadAccessoriesService headAccessoriesService;

    @GetMapping("/list")
    public List<HeadAccessoriesResponseDTO> getAllHeadAccessories() {
        return headAccessoriesService.getAll();
    }

    @GetMapping("/{id}")
    public HeadAccessoriesResponseDTO getHeadAccessoriesById(@PathVariable Integer id) {
        return headAccessoriesService.getById(id);
    }

    @PostMapping("/add")
    public void createHeadAccessories(@RequestBody HeadAccessoriesRequestDTO request) {
        headAccessoriesService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateHeadAccessories(@PathVariable Integer id, @RequestBody HeadAccessoriesRequestDTO request) {
        headAccessoriesService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHeadAccessories(@PathVariable Integer id) {
        headAccessoriesService.delete(id);
    }
}
