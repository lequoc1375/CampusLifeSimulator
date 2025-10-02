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

import com.example.app.dto.requestDTO.LowerClothRequestDTO;
import com.example.app.dto.responseDTO.LowerClothResponseDTO;
import com.example.app.service.serviceInterface.LowerClothService;

@RestController
@RequestMapping("/admin/api/lowercloth")
public class LowerClothRestController {

    @Autowired
    private LowerClothService lowerClothService;

    @GetMapping("/list")
    public List<LowerClothResponseDTO> getAllLowerCloths() {
        return lowerClothService.getAll();
    }

    @GetMapping("/{id}")
    public LowerClothResponseDTO getLowerClothById(@PathVariable Integer id) {
        return lowerClothService.getById(id);
    }

    @PostMapping("/add")
    public void createLowerCloth(@RequestBody LowerClothRequestDTO request) {
        lowerClothService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateLowerCloth(@PathVariable Integer id, @RequestBody LowerClothRequestDTO request) {
        lowerClothService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLowerCloth(@PathVariable Integer id) {
        lowerClothService.delete(id);
    }
}
