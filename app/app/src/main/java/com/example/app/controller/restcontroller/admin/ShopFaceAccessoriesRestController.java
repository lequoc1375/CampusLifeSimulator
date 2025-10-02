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

import com.example.app.dto.requestDTO.ShopFaceAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopFaceAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.ShopFaceAccessoriesService;


@RestController
@RequestMapping("/admin/api")
public class ShopFaceAccessoriesRestController {

    @Autowired
    private ShopFaceAccessoriesService service;

    @PostMapping("/shopFaceAccessories/add")
    public ResponseEntity<String> create(@RequestBody ShopFaceAccessoriesRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopFaceAccessories created successfully");
    }


    @GetMapping("/shopFaceAccessories/list")
    public ResponseEntity<List<ShopFaceAccessoriesResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/shopFaceAccessories/get/{id}")
    public ResponseEntity<ShopFaceAccessoriesResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopFaceAccessories/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopFaceAccessoriesRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopFaceAccessories updated successfully");
    }

    @DeleteMapping("/shopFaceAccessories/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopFaceAccessories deleted successfully");
    }

}
