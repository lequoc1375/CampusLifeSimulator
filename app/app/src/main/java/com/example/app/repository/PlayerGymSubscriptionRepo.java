package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.PlayerGymSubscription;
import com.example.app.entity.User;

public interface PlayerGymSubscriptionRepo extends JpaRepository<PlayerGymSubscription, Integer> {
    Optional<PlayerGymSubscription> findByUser(User user);
}
