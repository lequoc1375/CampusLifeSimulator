package com.example.app.dto.responseDTO;

public class ShopFootClothResponseDTO {
    private int shopFootId;
    private String status;
    private int footId;
    private int shopId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getShopFootId() {
        return shopFootId;
    }

    public void setShopFootId(int shopFootId) {
        this.shopFootId = shopFootId;
    }

    public int getFootId() {
        return footId;
    }

    public void setFootId(int footId) {
        this.footId = footId;
    }

}
