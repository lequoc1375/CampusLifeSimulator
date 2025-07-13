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

import com.example.app.dto.requestDTO.MidtermDTORequest;
import com.example.app.dto.responseDTO.MidtermDTOResponse;
import com.example.app.service.serviceInterface.MidtermService;

@RestController
@RequestMapping("/admin/api/midterm")
public class MidtermRestController {

    @Autowired
    private MidtermService midtermService;

    @PostMapping("/add")
    public void addMidterm(@RequestBody MidtermDTORequest request) {
        midtermService.addMidterm(request);
    }

    @GetMapping("/list")
    public List<MidtermDTOResponse> getAllMidterms() {
        return midtermService.getAllMidterms();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMidterm(@PathVariable Integer id) {
        midtermService.deleteMidterm(id);
    }

    @PutMapping("/update/{id}")
    public void updateMidterm(@PathVariable Integer id, @RequestBody MidtermDTORequest request) {
        midtermService.updateMidterm(id, request);
    }

    @GetMapping("/{id}")
    public MidtermDTOResponse getMidterm(@PathVariable int id) {
        return midtermService.getMidterm(id);
    }
}
