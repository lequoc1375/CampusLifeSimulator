package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.app.dto.requestDTO.RegisterDTOrq;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerDTOrq", new RegisterDTOrq());
        return "Register";
    }

    @PostMapping("/register")
    public String postMethodName(@RequestBody(required = false) String entity) {
        // TODO: process POST request

        return "redirect:/login";
    }

}
