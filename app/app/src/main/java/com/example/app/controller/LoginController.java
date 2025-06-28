package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.app.dto.requestDTO.LoginDTOrq;



@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        LoginDTOrq loginDTOrq = new LoginDTOrq();
        model.addAttribute("loginDTOrq",loginDTOrq);
        return "Login";
    }

    @PostMapping("/login")
    public String postMethodName(@RequestBody(required=false) String entity) {
        //TODO: process POST request
        
        return "redirect:/Game/HomePage";
    }
    
    
}
