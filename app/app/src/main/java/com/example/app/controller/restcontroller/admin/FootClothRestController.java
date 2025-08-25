package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.dto.requestDTO.FootClothRequestDTO;
import com.example.app.dto.responseDTO.FootClothResponseDTO;
import com.example.app.service.serviceInterface.FootClothService;

@RestController
@RequestMapping("/admin/api/footcloth")
public class FootClothRestController {

    @Autowired
    private FootClothService footClothService;

    @GetMapping("/list")
    public List<FootClothResponseDTO> getAllFootCloths() {
        return footClothService.getAll();
    }

    @GetMapping("/{id}")
    public FootClothResponseDTO getFootClothById(@PathVariable Integer id) {
        return footClothService.getById(id);
    }

    @PostMapping("/add")
    public void createFootCloth(@RequestBody FootClothRequestDTO request) {
        footClothService.create(request);
    }

    @PutMapping("/update/{id}")
    public void updateFootCloth(@PathVariable Integer id, @RequestBody FootClothRequestDTO request) {
        footClothService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFootCloth(@PathVariable Integer id) {
        footClothService.delete(id);
    }
}
