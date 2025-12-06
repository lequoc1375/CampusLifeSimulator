package com.example.app.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.responseDTO.GymProgressResponseDTO;
import com.example.app.dto.responseDTO.GymTrainResponseDTO;
import com.example.app.entity.GymExercise;
import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;
import com.example.app.repository.GymExerciseRepo;
import com.example.app.repository.PlayerStatsRepo;
import com.example.app.service.serviceInterface.GymProgressService;
import com.example.app.service.serviceInterface.GymSubscriptionService;
import com.example.app.service.serviceInterface.PlayerStatsService;

@Service
public class GymTrainingService {

    @Autowired
    private GymExerciseRepo exerciseRepo;

    @Autowired
    private GymProgressService progressService;

    @Autowired
    private GymSubscriptionService subscriptionService;

    @Autowired
    private PlayerStatsService statsService;

    @Autowired
    private PlayerStatsRepo playerStatsRepo;

    public GymTrainResponseDTO train(User user, Integer exerciseId) {

        if (!subscriptionService.hasActivePackage(user)) {
            throw new RuntimeException("Gym package required");
        }

        GymExercise ex = exerciseRepo.findById(exerciseId)
            .orElseThrow(() -> new RuntimeException("Exercise not found"));

        statsService.consumeEnergyAndStress(
            user,
            ex.getEnergyCost(),
            ex.getStressIncrease()
        );

        PlayerStats stats = statsService.getStats(user);

        GymProgressResponseDTO progress = progressService.gainExp(user, ex.getExpReward());

        boolean levelUp = progress.isLevelUp();

        if (levelUp) {
            statsService.gymLevelUp(user);
            stats = statsService.getStats(user);
        }

        playerStatsRepo.save(stats);

        return new GymTrainResponseDTO(
            ex.getName(),
            ex.getExpReward(),
            levelUp,
            progress.getLevel(),
            progress.getExp(),
            progress.getExpToNextLv(),
            stats.getCurrentEnergy(),
            stats.getCurrentStress(),
            stats.getMaxEnergy(),
            levelUp ? "Level up! +5 maximum energy" : "Training successful"
        );
    }
}
