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

import com.example.app.dto.requestDTO.ShopLowerClothRequestDTO;
import com.example.app.dto.responseDTO.ShopLowerClothResponseDTO;
import com.example.app.service.serviceInterface.ShopLowerClothService;

@RestController
@RequestMapping("/admin/api")
public class ShopLowerClothRestController {

    @Autowired
    private ShopLowerClothService service;

    @PostMapping("/shopLowerCloth/add")
    public ResponseEntity<String> create(@RequestBody ShopLowerClothRequestDTO request) {
        service.create(request);
        return ResponseEntity.ok("ShopLowerCloth created successfully");
    }


    @GetMapping("/shopLowerCloth/list")
    public ResponseEntity<List<ShopLowerClothResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/shopLowerCloth/get/{id}")
    public ResponseEntity<ShopLowerClothResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/shopLowerCloth/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ShopLowerClothRequestDTO request) {
        service.update(id, request);
        return ResponseEntity.ok("ShopLowerCloth updated successfully");
    }

    @DeleteMapping("/shopLowerCloth/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("ShopLowerCloth deleted successfully");
    }

}
