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

import com.example.app.dto.requestDTO.ShopBackAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopBackAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.ShopBackAccessoriesService;


@RestController
@RequestMapping("/admin/api")
public class ShopBackAccessoriesRestController {

    @Autowired
    private ShopBackAccessoriesService service;

    @PostMapping("/shopBackAccessories/add")
    public ResponseEntity<String> create(@RequestBody ShopBackAccessoriesRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopBackAccessories created successfully");
    }


    @GetMapping("/shopBackAccessories/list")
    public ResponseEntity<List<ShopBackAccessoriesResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/shopBackAccessories/get/{id}")
    public ResponseEntity<ShopBackAccessoriesResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopBackAccessories/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopBackAccessoriesRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopBackAccessories updated successfully");
    }

    @DeleteMapping("/shopBackAccessories/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopBackAccessories deleted successfully");
    }

}
