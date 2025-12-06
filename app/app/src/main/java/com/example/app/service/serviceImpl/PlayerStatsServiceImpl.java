package com.example.app.service.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.responseDTO.PurchaseResponseDTO;
import com.example.app.entity.Food;
import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;
import com.example.app.repository.FoodRepo;
import com.example.app.repository.PlayerStatsRepo;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.PlayerStatsService;

import jakarta.transaction.Transactional;

@Service
public class PlayerStatsServiceImpl implements PlayerStatsService {

    @Autowired
    private PlayerStatsRepo playerStatsRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FoodRepo foodRepo;

    @Override
    public List<PlayerStats> getAll() {
        return playerStatsRepo.findAll();
    }

    @Override
    public PlayerStats getStats(User user) {
        return playerStatsRepo.findByUserUserId(user.getUserId());
    }

    @Override
    public PlayerStats getByUserId(int id) {
        return playerStatsRepo.findByUserUserId(id);
    }

    @Override
    public void create(User user, int age, BigDecimal money, int max_energy, int current_energy, int max_stress, int current_stress) {
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
    public PlayerStats updateMoney(int userId, BigDecimal newMoney) {
        PlayerStats existing = playerStatsRepo.findByUserUserId(userId);
        if (existing == null) return null;

        existing.setMoney(newMoney);

        return playerStatsRepo.save(existing);
    }

    @Override
    public PlayerStats update(int id, PlayerStats updatedStats) {
        PlayerStats existing = playerStatsRepo.findById(id).orElse(null);
        if (existing == null) return null;

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

    @Override
    public void updateEnergy(int userId, int delta) {
        PlayerStats ps = playerStatsRepo.findByUserUserId(userId);

        int newEnergy = ps.getCurrentEnergy() + delta;
        newEnergy = Math.max(0, Math.min(ps.getMaxEnergy(), newEnergy));
        ps.setCurrentEnergy(newEnergy);

        playerStatsRepo.save(ps);
    }

    @Override
    public void updateStress(int userId, int delta) {
        PlayerStats ps = playerStatsRepo.findByUserUserId(userId);

        int newStress = ps.getCurrentStress() + delta;
        newStress = Math.max(0, Math.min(ps.getMaxStress(), newStress));
        ps.setCurrentStress(newStress);

        playerStatsRepo.save(ps);
    }

    @Override
    public void save(PlayerStats ps) {
       playerStatsRepo.save(ps);
    }

    @Override
    @Transactional
    public PurchaseResponseDTO purchaseFood(int userId, int foodId) throws Exception {

        PlayerStats playerStats = playerStatsRepo.findByUserUserId(userId);
            if (playerStats == null) {
                throw new Exception("Player stats not found");
            }

        Food food = foodRepo.findById(foodId)
                .orElseThrow(() -> new Exception("Food not found with id: " + foodId));

        BigDecimal foodPrice = food.getPrice();

        if (playerStats.getMoney().compareTo(foodPrice) < 0) {
            throw new Exception("Insufficient balance. Required: $" + foodPrice 
                            + ", Available: $" + playerStats.getMoney());
        }

        playerStats.setMoney(playerStats.getMoney().subtract(foodPrice));

        int newEnergy = playerStats.getCurrentEnergy() + food.getEnergyAffected();
        newEnergy = Math.min(newEnergy, playerStats.getMaxEnergy());
        playerStats.setCurrentEnergy(newEnergy);

        int newStress = playerStats.getCurrentStress() + food.getStressAffected();
        newStress = Math.max(newStress, 0);
        newStress = Math.min(newStress, playerStats.getMaxStress());
        playerStats.setCurrentStress(newStress);

        playerStatsRepo.save(playerStats);

        return new PurchaseResponseDTO(
            food.getName(),
            food.getEnergyAffected(),
            food.getStressAffected(),
            playerStats.getMoney(),
            playerStats.getCurrentEnergy(),
            playerStats.getCurrentStress(),
            playerStats.getMaxEnergy(),
            playerStats.getMaxStress(),
            "Purchase successful!"
        );
    }
    
    @Override
    @Transactional
    public void consumeEnergyAndStress(User user, int energyCost, int stressIncrease) {

        PlayerStats ps = playerStatsRepo.findByUserUserId(user.getUserId());

        if (ps == null)
            throw new RuntimeException("Player stats not found");

        if (ps.getCurrentEnergy() < energyCost) {
            throw new RuntimeException("Not enough energy to train");
        }

        int newEnergy = ps.getCurrentEnergy() - energyCost;
        ps.setCurrentEnergy(newEnergy);

        int newStress = ps.getCurrentStress() + stressIncrease;
        newStress = Math.min(newStress, ps.getMaxStress());
        ps.setCurrentStress(newStress);

        playerStatsRepo.save(ps);
    }

    @Override
    public void gymLevelUp(User user) {
        PlayerStats ps = playerStatsRepo.findByUserUserId(user.getUserId());

        if (ps == null)
            throw new RuntimeException("Player stats not found");

        int newMaxEnergy = ps.getMaxEnergy() + 5;
        ps.setMaxEnergy(newMaxEnergy);

        playerStatsRepo.save(ps);
    }
}
