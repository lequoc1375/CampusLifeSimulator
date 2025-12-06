package com.example.app.dto.responseDTO;

import lombok.Data;

@Data
public class GymProgressResponseDTO {
    private Integer level;
    private Integer exp;
    private Integer expToNextLv;
    private boolean levelUp;
}
