package com.example.app.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTOResponse {
    private Integer jobId;
    private String name;
    private Integer energyAffected;
    private Integer stressAffected;
    private Integer salary;
    private Integer contractPeriod;
    private Double expMultiple;
}
