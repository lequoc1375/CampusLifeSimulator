package com.example.app.controller.restcontroller.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;
import com.example.app.service.serviceInterface.PlayerStatsService;
import com.example.app.service.serviceInterface.UserService;

@RestController
@RequestMapping("/player/api/stats")
public class PlayerStatsRestController {

    @Autowired
    private PlayerStatsService playerStatsService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<PlayerStats> getAllStats() {
        return playerStatsService.getAll();
    }

    @GetMapping("/me")
    public PlayerStats getStatsForCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUsername(username);
        return playerStatsService.getByUserId(user.getUser_id());
    }

    @PutMapping("/{id}")
    public PlayerStats updateStats(@PathVariable int id, @RequestBody PlayerStats stats) {
        return playerStatsService.update(id, stats);
    }

    @PutMapping("/update-money/{id}")
    public PlayerStats updateMoney(@PathVariable int id, @RequestBody double newMoney) {
        return playerStatsService.updateMoney(id, newMoney);
    }

    @DeleteMapping("/{id}")
    public void deleteStats(@PathVariable int id) {
        playerStatsService.delete(id);
    }
}

