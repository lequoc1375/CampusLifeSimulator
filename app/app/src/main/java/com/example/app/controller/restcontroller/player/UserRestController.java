package com.example.app.controller.restcontroller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.service.serviceInterface.UserService;

@RestController
@RequestMapping("/player/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public String getUsername (@PathVariable int id) {
        return userService.getUsernameByUserId(id);
    }

}
