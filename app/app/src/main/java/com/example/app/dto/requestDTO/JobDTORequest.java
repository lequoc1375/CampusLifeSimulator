package com.example.app.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTORequest {
    private String name;
    private Integer energyAffected;
    private Integer stressAffected;
    private Integer salary;
    private Integer contractPeriod;
    private Double expMultiple;
}
