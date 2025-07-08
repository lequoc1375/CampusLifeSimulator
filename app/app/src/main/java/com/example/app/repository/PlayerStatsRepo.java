package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;

public interface PlayerStatsRepo extends JpaRepository<PlayerStats, Integer> {
    PlayerStats findByUserUserId(int userId);
}
