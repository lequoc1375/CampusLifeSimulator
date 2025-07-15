package com.example.app.dto.responseDTO;

import java.math.BigDecimal;

import com.example.app.entity.Food.LivingRequirement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class FoodDTOResponse {
    private Integer foodId;
    private String name;
    private Integer energyAffected;
    private Integer stressAffected;
    private BigDecimal price;
    private String type;
    private LivingRequirement livingRequirement;
    public Integer getFoodId() {
        return foodId;
    }
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }
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
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
