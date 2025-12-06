package com.example.app.dto.requestDTO;

import java.math.BigDecimal;

import com.example.app.entity.Food.LivingRequirement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class FoodDTORequest {

    private String name;
    private Integer energyAffected;
    private Integer stressAffected;
    private BigDecimal price;
    private String type;
    private LivingRequirement livingRequirement;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getEnergyAffected() {
        return energyAffected;
    }
    public void setEnergyAffected(Integer energyAffected) {
        this.energyAffected = energyAffected;
    }
    public Integer getStressAffected() {
        return stressAffected;
    }
    public void setStressAffected(Integer stressAffected) {
        this.stressAffected = stressAffected;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public LivingRequirement getLivingRequirement() {
        return livingRequirement;
    }
    public void setLivingRequirement(LivingRequirement livingRequirement) {
        this.livingRequirement = livingRequirement;
    }
}
