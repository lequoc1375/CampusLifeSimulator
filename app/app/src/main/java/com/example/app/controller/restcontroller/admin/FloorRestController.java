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

import com.example.app.dto.requestDTO.FloorDTORequest;
import com.example.app.dto.responseDTO.FloorDTOResponse;
import com.example.app.service.serviceInterface.FloorService;

@RestController
@RequestMapping("/admin/api/floor")
public class FloorRestController {

    @Autowired
    private FloorService floorService;

    @GetMapping("/all")
    public List<FloorDTOResponse> getAll() {
        return floorService.getAll();
    }

    @GetMapping("/{id}")
    public FloorDTOResponse getById(@PathVariable int id) {
        return floorService.getById(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody FloorDTORequest request) {
        floorService.create(request);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody FloorDTORequest request) {
        floorService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        floorService.delete(id);
    }
}
