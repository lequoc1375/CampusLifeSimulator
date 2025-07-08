package com.example.app.controller.restcontroller.player;

import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;
import com.example.app.service.serviceInterface.PlayerStatsService;
import com.example.app.service.serviceInterface.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getByUser/{id}")
    public PlayerStats getStatsByUserId(@PathVariable int id) {
        return playerStatsService.getByUserId(id);
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

