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

import com.example.app.dto.requestDTO.ShopFootClothRequestDTO;
import com.example.app.dto.responseDTO.ShopFootClothResponseDTO;
import com.example.app.service.serviceInterface.ShopFootClothService;

@RestController
@RequestMapping("/admin/api")
public class ShopFootClothRestController {

    @Autowired
    private ShopFootClothService service;

    @PostMapping("/shopFootCloth/add")
    public ResponseEntity<String> create(@RequestBody ShopFootClothRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopFootCloth created successfully");
    }

    @GetMapping("/shopFootCloth/list")
    public ResponseEntity<List<ShopFootClothResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/shopFootCloth/get/{id}")
    public ResponseEntity<ShopFootClothResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopFootCloth/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopFootClothRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopFootCloth updated successfully");
    }

    @DeleteMapping("/shopFootCloth/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopFootCloth deleted successfully");
    }

}
