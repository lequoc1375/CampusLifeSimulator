package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;

public interface PlayerStatsService {
    List<PlayerStats> getAll();
    PlayerStats getByUserId(int id);
    void create(User user, int age, double money, int max_energy, int current_energy, int max_stress, int current_stress);
    PlayerStats update(int id, PlayerStats stats);
    PlayerStats updateMoney(int id, double newMoney);
    void delete(int id);
    void updateEnergy(int id, int energy);
    void updateStress(int id, int stressfull);
    void save(PlayerStats ps);
}
