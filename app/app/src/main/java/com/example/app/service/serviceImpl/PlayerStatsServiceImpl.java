package com.example.app.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;
import com.example.app.repository.PlayerStatsRepo;
import com.example.app.service.serviceInterface.PlayerStatsService;

@Service
public class PlayerStatsServiceImpl implements PlayerStatsService {

    @Autowired
    private PlayerStatsRepo playerStatsRepo;

    @Override
    public List<PlayerStats> getAll() {
        return playerStatsRepo.findAll();
    }

    @Override
    public PlayerStats getByUserId(int id) {
        return playerStatsRepo.findByUserUserId(id);
    }

    @Override
    public void create(User user, int age, double money, int max_energy, int current_energy, int max_stress, int current_stress) {
        PlayerStats playerStats = new PlayerStats();
        playerStats.setUser(user);
        playerStats.setAge(age);
        playerStats.setMoney(money);
        playerStats.setMaxEnergy(max_energy);
        playerStats.setCurrentEnergy(current_energy);
        playerStats.setMaxStress(max_stress);
        playerStats.setCurrentStress(current_stress);

        playerStatsRepo.save(playerStats);
    }

    @Override
    public PlayerStats updateMoney(int id, double newMoney) {
        PlayerStats existing = playerStatsRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setMoney(newMoney);

        return playerStatsRepo.save(existing);
    }

    @Override
    public PlayerStats update(int id, PlayerStats updatedStats) {
        PlayerStats existing = playerStatsRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setUser(updatedStats.getUser());
        existing.setAge(updatedStats.getAge());
        existing.setMoney(updatedStats.getMoney());
        existing.setMaxEnergy(updatedStats.getMaxEnergy());
        existing.setCurrentEnergy(updatedStats.getCurrentEnergy());
        existing.setMaxStress(updatedStats.getMaxStress());
        existing.setCurrentStress(updatedStats.getCurrentStress());

        return playerStatsRepo.save(existing);
    }

    @Override
    public void delete(int id) {
        playerStatsRepo.deleteById(id);
    }
    
}
