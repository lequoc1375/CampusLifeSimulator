package com.example.app.dto.responseDTO;

import lombok.Data;

@Data
public class GymExerciseDTOResponse {
    private Integer gymExerciseId;
    private String name;
    private int energyCost;
    private int stressIncrease;
    private int expReward;
    private Integer minLevel;
    private String imageUrl;
}


