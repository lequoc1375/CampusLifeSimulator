package com.example.app.dto.requestDTO;

public class ShopFootClothRequestDTO {
    private int shopId;
    private String status;
    private int footId;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFootId() {
        return footId;
    }

    public void setFootId(int footId) {
        this.footId = footId;
    }

}
