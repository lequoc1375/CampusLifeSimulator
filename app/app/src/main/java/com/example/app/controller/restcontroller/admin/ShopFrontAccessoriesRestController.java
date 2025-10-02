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

import com.example.app.dto.requestDTO.ShopFrontAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopFrontAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.ShopFrontAccessoriesService;


@RestController
@RequestMapping("/admin/api")
public class ShopFrontAccessoriesRestController {

    @Autowired
    private ShopFrontAccessoriesService service;

    @PostMapping("/shopFrontAccessories/add")
    public ResponseEntity<String> create(@RequestBody ShopFrontAccessoriesRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopFrontAccessories created successfully");
    }


    @GetMapping("/shopFrontAccessories/list")
    public ResponseEntity<List<ShopFrontAccessoriesResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/shopFrontAccessories/get/{id}")
    public ResponseEntity<ShopFrontAccessoriesResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopFrontAccessories/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopFrontAccessoriesRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopFrontAccessories updated successfully");
    }

    @DeleteMapping("/shopFrontAccessories/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopFrontAccessories deleted successfully");
    }

}
