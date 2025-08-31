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

import com.example.app.dto.requestDTO.ShopUpperClothRequestDTO;
import com.example.app.dto.responseDTO.ShopUpperClothResponseDTO;
import com.example.app.service.serviceInterface.ShopUpperClothService;

@RestController
@RequestMapping("/admin/api")
public class ShopUpperClothRestController {

    @Autowired
    private ShopUpperClothService service;

    @PostMapping("/shopUpperCloth/add")
    public ResponseEntity<String> create(@RequestBody ShopUpperClothRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopUpperCloth created successfully");
    }


    @GetMapping("/shopUpperCloth/list")
    public ResponseEntity<List<ShopUpperClothResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/shopUpperCloth/get/{id}")
    public ResponseEntity<ShopUpperClothResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopUpperCloth/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopUpperClothRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopUpperCloth updated successfully");
    }

    @DeleteMapping("/shopUpperCloth/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopUpperCloth deleted successfully");
    }

}
