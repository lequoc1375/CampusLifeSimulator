package com.example.app.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class WallDTOResponse {
    private Integer wallId;
    private Double price;
    private String image;
    public Integer getWallId() {
        return wallId;
    }
    public void setWallId(Integer wallId) {
        this.wallId = wallId;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
}
