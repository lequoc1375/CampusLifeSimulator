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

import com.example.app.dto.requestDTO.MealDTORequest;
import com.example.app.dto.responseDTO.MealDTOResponse;
import com.example.app.service.serviceInterface.MealService;

@RestController
@RequestMapping("/admin/api/meal")
public class MealRestController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<MealDTOResponse> getAll() {
        return mealService.getAll();
    }

    @GetMapping("/{id}")
    public MealDTOResponse getById(@PathVariable int id) {
        return mealService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody MealDTORequest request) {
        mealService.create(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody MealDTORequest request) {
        mealService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        mealService.delete(id);
    }
}
