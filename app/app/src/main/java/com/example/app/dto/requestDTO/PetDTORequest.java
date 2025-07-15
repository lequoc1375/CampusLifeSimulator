package com.example.app.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PetDTORequest {
    private String name;
    private String image;
    private Double priceBuy;
    private Double priceSell;
    private Integer energyAffected;
    private Integer stressAffected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Double priceBuy) {
        this.priceBuy = priceBuy;
    }

    public Double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Double priceSell) {
        this.priceSell = priceSell;
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

}
