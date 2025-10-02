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
@Table(name = "living_place")
@NoArgsConstructor
@AllArgsConstructor
public class LivingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Integer placeId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "price_per_month", precision = 10, nullable = false)
    private Double pricePerMonth;

    @Column(name = "max_decor_item", nullable = false)
    private Integer maxDecorItem;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "size_x", nullable = false)
    private Integer sizeX;

    @Column(name = "size_y", nullable = false)
    private Integer sizeY;

    @Column(name = "size_z", nullable = false)
    private Integer sizeZ;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(Double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public Integer getMaxDecorItem() {
        return maxDecorItem;
    }

    public void setMaxDecorItem(Integer maxDecorItem) {
        this.maxDecorItem = maxDecorItem;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
