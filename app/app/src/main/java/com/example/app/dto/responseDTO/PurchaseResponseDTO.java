package com.example.app.dto.responseDTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponseDTO {
    
    private String foodName;
    private int energyAffected;
    private int stressAffected;
    
    private BigDecimal newBalance;
    private int newCurrentEnergy;
    private int newCurrentStress;
    private int maxEnergy;
    private int maxStress;
    private String message;
}