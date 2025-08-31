package com.example.app.dto.requestDTO;

public class ShopFullClothRequestDTO {
    private int shopId;
    private String status;
    private int fullId;

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

    public int getFullId() {
        return fullId;
    }

    public void setFullId(int fullId) {
        this.fullId = fullId;
    }

}
