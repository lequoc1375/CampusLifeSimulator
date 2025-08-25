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

import com.example.app.dto.requestDTO.FullClothRequestDTO;
import com.example.app.dto.responseDTO.FullClothResponseDTO;
import com.example.app.service.serviceInterface.FullClothService;

@RestController
@RequestMapping("/admin/api/fullcloth")
public class FullClothRestController {

    @Autowired
    private FullClothService fullClothService;

    @GetMapping("/list")
    public List<FullClothResponseDTO> getAllFullCloths() {
        return fullClothService.getAll();
    }

    @GetMapping("/{id}")
    public FullClothResponseDTO getFullClothById(@PathVariable Integer id) {
        return fullClothService.getById(id);
    }

    @PostMapping("/add")
    public void createFullCloth(@RequestBody FullClothRequestDTO request) {
        fullClothService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateFullCloth(@PathVariable Integer id, @RequestBody FullClothRequestDTO request) {
        fullClothService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFullCloth(@PathVariable Integer id) {
        fullClothService.delete(id);
    }
}
