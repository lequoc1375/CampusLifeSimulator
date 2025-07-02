package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.PlayerProfile;

public interface PlayerProfileRepo extends JpaRepository<PlayerProfile, Object> {
    PlayerProfile findByEmail(String email);
    PlayerProfile findByPhone(String phone);
}
