package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.dto.requestDTO.RegisterDTOrq;
import com.example.app.service.serviceInterface.UserService;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerDTOrq", new RegisterDTOrq());
        return "Register";
    }

    @PostMapping("/register")
    public String postMethodName(@ModelAttribute RegisterDTOrq registerDTOrq) {
        boolean success = userService.register(registerDTOrq.getUsername(), registerDTOrq.getPassword());
        if (!success) {
            return "Register";
        }
        return "redirect:/login";
    }

}
