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

import com.example.app.dto.requestDTO.DecorItemDTORequest;
import com.example.app.dto.responseDTO.DecorItemDTOResponse;
import com.example.app.service.serviceInterface.DecorItemService;

@RestController
@RequestMapping("/admin/api/decor-item")
public class DecorItemRestController {

    @Autowired
    private DecorItemService service;

    @GetMapping
    public List<DecorItemDTOResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DecorItemDTOResponse getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody DecorItemDTORequest dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody DecorItemDTORequest dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
