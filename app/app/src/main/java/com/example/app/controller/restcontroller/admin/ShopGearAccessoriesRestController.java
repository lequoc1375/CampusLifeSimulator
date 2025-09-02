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

import com.example.app.dto.requestDTO.ShopGearAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopGearAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.ShopGearAccessoriesService;


@RestController
@RequestMapping("/admin/api")
public class ShopGearAccessoriesRestController {

    @Autowired
    private ShopGearAccessoriesService service;

    @PostMapping("/shopGearAccessories/add")
    public ResponseEntity<String> create(@RequestBody ShopGearAccessoriesRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopGearAccessories created successfully");
    }


    @GetMapping("/shopGearAccessories/list")
    public ResponseEntity<List<ShopGearAccessoriesResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/shopGearAccessories/get/{id}")
    public ResponseEntity<ShopGearAccessoriesResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopGearAccessories/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopGearAccessoriesRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopGearAccessories updated successfully");
    }

    @DeleteMapping("/shopGearAccessories/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopGearAccessories deleted successfully");
    }

}
