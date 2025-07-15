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

import com.example.app.dto.requestDTO.FoodDTORequest;
import com.example.app.dto.responseDTO.FoodDTOResponse;
import com.example.app.service.serviceInterface.FoodService;

@RestController
@RequestMapping("/admin/api/food")
public class FoodRestController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<FoodDTOResponse> getAll() {
        return foodService.getAll();
    }

    @GetMapping("/{id}")
    public FoodDTOResponse getById(@PathVariable int id) {
        return foodService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody FoodDTORequest request) {
        foodService.create(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody FoodDTORequest request) {
        foodService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        foodService.delete(id);
    }
}
