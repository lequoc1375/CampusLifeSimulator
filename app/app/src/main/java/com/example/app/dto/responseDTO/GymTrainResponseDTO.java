package com.example.app.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymTrainResponseDTO {

    private String exerciseName;
    private int expGained;

    private boolean levelUp;
    private int newLevel;
    private int currentExp;
    private int expToNextLv;

    private int energy;
    private int stress;
    private int maxEnergy;

    private String message;
}

