package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.service.serviceInterface.UpperClothService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.dto.requestDTO.UpperClothRequestDTO;
import com.example.app.dto.responseDTO.UpperClothResponseDTO;

@RestController
@RequestMapping("/admin/api/uppercloth")
public class UpperClothRestController {

    @Autowired
    private UpperClothService upperClothService;

    @GetMapping("/list")
    public List<UpperClothResponseDTO> getAllUpperCloths() {
        return upperClothService.getAll();
    }

    @GetMapping("/{id}")
    public UpperClothResponseDTO getUpperClothById(@PathVariable Integer id) {
        return upperClothService.getById(id);
    }

    @PostMapping("/add")
    public void createUpperCloth(@RequestBody UpperClothRequestDTO request) {
        upperClothService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateUpperCloth(@PathVariable Integer id, @RequestBody UpperClothRequestDTO request) {
        upperClothService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUpperCloth(@PathVariable Integer id) {
        upperClothService.delete(id);
    }
}
