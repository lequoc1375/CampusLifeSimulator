package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.requestDTO.ShopFullClothRequestDTO;
import com.example.app.dto.responseDTO.ShopFullClothResponseDTO;
import com.example.app.service.serviceInterface.ShopFullClothService;

@RestController
@RequestMapping("/admin/api")
public class ShopFullClothRestController {

    @Autowired
    private ShopFullClothService service;

    @PostMapping("/shopFullCloth/add")
    public ResponseEntity<String> create(@RequestBody ShopFullClothRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopFullCloth created successfully");
    }


    @GetMapping("/shopFullCloth/list")
    public ResponseEntity<List<ShopFullClothResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/shopFullCloth/get/{id}")
    public ResponseEntity<ShopFullClothResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopFullCloth/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopFullClothRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopFullCloth updated successfully");
    }

    @DeleteMapping("/shopFullCloth/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopFullCloth deleted successfully");
    }

}
