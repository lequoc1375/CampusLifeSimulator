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

import com.example.app.dto.requestDTO.ShopHeadAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopHeadAccessoriesResponseDTO;
import com.example.app.service.serviceInterface.ShopHeadAccessoriesService;


@RestController
@RequestMapping("/admin/api")
public class ShopHeadAccessoriesRestController {

    @Autowired
    private ShopHeadAccessoriesService service;

    @PostMapping("/shopHeadAccessories/add")
    public ResponseEntity<String> create(@RequestBody ShopHeadAccessoriesRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopHeadAccessories created successfully");
    }


    @GetMapping("/shopHeadAccessories/list")
    public ResponseEntity<List<ShopHeadAccessoriesResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/shopHeadAccessories/get/{id}")
    public ResponseEntity<ShopHeadAccessoriesResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopHeadAccessories/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopHeadAccessoriesRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopHeadAccessories updated successfully");
    }

    @DeleteMapping("/shopHeadAccessories/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopHeadAccessories deleted successfully");
    }

}
