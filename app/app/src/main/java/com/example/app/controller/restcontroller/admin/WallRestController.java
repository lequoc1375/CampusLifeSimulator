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

import com.example.app.dto.requestDTO.WallDTORequest;
import com.example.app.dto.responseDTO.WallDTOResponse;
import com.example.app.service.serviceInterface.WallService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/api/wall")
@RequiredArgsConstructor
public class WallRestController {
    @Autowired
    private WallService wallService;

    @PostMapping("/add")
    public WallDTOResponse add(@RequestBody WallDTORequest dto) {
        return wallService.add(dto);
    }

    @GetMapping("/all")
    public List<WallDTOResponse> getAll() {
        return wallService.getAll();
    }

    @PutMapping("/update/{id}")
    public WallDTOResponse update(@PathVariable Integer id, @RequestBody WallDTORequest dto) {
        return wallService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        wallService.delete(id);
    }
}
