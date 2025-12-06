package com.example.app.dto.requestDTO;

import lombok.Data;

@Data
public class GymExerciseDTORequest {
    private String name;
    private int energyCost;
    private int stressIncrease;
    private int expReward;
    private Integer minLevel;
}


