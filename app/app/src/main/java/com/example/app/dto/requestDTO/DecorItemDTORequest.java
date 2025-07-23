package com.example.app.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DecorItemDTORequest {
    private String image;
    private String category;
    private Double price;
    private Integer energyAffected;
    private Integer stressAffected;
    private Integer sizeX;
    private Integer sizeY;
    private Integer sizeZ;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Integer getSizeX() {
        return sizeX;
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX = sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY = sizeY;
    }

    public Integer getSizeZ() {
        return sizeZ;
    }

    public void setSizeZ(Integer sizeZ) {
        this.sizeZ = sizeZ;
    }

}
