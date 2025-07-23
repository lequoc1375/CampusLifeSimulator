package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "decor_item")

@NoArgsConstructor
@AllArgsConstructor
public class DecorItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decor_item_id")
    private Integer decorItemId;

    @Column(name = "image")
    private String image;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Double price;

    @Column(name = "energy_affected")
    private Integer energyAffected;

    @Column(name = "stress_affected")
    private Integer stressAffected;

    @Column(name = "size_x")
    private Integer sizeX;

    @Column(name = "size_y")
    private Integer sizeY;

    @Column(name = "size_z")
    private Integer sizeZ;

    public Integer getDecorItemId() {
        return decorItemId;
    }

    public void setDecorItemId(Integer decorItemId) {
        this.decorItemId = decorItemId;
    }

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
