package com.example.app.repository;

import com.example.app.entity.PlayerAvatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerAvatarRepo extends JpaRepository<PlayerAvatar, Integer> {

    PlayerAvatar findByUser_UserId(int userId);
}