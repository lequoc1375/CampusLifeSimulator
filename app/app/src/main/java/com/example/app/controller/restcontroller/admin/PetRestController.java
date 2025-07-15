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

import com.example.app.dto.requestDTO.PetDTORequest;
import com.example.app.dto.responseDTO.PetDTOResponse;
import com.example.app.service.serviceInterface.PetService;

@RestController
@RequestMapping("/admin/api/pet")
public class PetRestController {

    @Autowired
    private PetService petService;

    @PostMapping
    public void create(@RequestBody PetDTORequest request) {
        petService.create(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody PetDTORequest request) {
        petService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        petService.delete(id);
    }

    @GetMapping
    public List<PetDTOResponse> getAll() {
        return petService.getAll();
    }

    @GetMapping("/{id}")
    public PetDTOResponse getById(@PathVariable int id) {
        return petService.getById(id);
    }
}
