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

import com.example.app.dto.requestDTO.FinalDTORequest;
import com.example.app.dto.responseDTO.FinalDTOResponse;
import com.example.app.service.serviceInterface.FinalService;

@RestController
@RequestMapping("/admin/api/final")
public class FinalRestController {

    @Autowired
    private FinalService finalService;

    @PostMapping("/add")
    public void addFinal(@RequestBody FinalDTORequest request) {
        finalService.addFinal(request);
    }

    @GetMapping("/list")
    public List<FinalDTOResponse> getAllFinals() {
        return finalService.getAllFinal();
    }

    @GetMapping("/{id}")
    public FinalDTOResponse getFinal(@PathVariable int id) {
        return finalService.getFinal(id);
    }

    @PutMapping("/update/{id}")
    public void updateFinal(@PathVariable Integer id, @RequestBody FinalDTORequest request) {
        finalService.updateFinal(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFinal(@PathVariable Integer id) {
        finalService.deleteFinal(id);
    }
}
