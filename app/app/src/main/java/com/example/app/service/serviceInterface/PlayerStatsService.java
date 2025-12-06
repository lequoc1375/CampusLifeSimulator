package com.example.app.service.serviceInterface;

import java.math.BigDecimal;
import java.util.List;

import com.example.app.dto.responseDTO.PurchaseResponseDTO;
import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;

public interface PlayerStatsService {
    List<PlayerStats> getAll();
    PlayerStats getByUserId(int id);
    void create(User user, int age, BigDecimal money, int max_energy, int current_energy, int max_stress, int current_stress);
    PlayerStats update(int id, PlayerStats stats);
    PlayerStats updateMoney(int id, BigDecimal newMoney);
    void delete(int id);
    void updateEnergy(int id, int energy);
    void updateStress(int id, int stressfull);
    void save(PlayerStats ps);
    PurchaseResponseDTO purchaseFood(int userId, int foodId) throws Exception;
    void consumeEnergyAndStress(User user, int energyCost, int stressIncrease);
    PlayerStats getStats(User user);
    void gymLevelUp(User user);

}
