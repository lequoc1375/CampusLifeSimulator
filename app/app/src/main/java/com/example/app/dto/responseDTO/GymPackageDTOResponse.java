package com.example.app.dto.responseDTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GymPackageDTOResponse {
    private Integer gymPackageId;
    private String packageName;
    private BigDecimal price;
    private Integer durationDays;
}
