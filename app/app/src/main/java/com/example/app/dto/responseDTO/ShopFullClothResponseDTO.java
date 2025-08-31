package com.example.app.dto.responseDTO;

public class ShopFullClothResponseDTO {
    private int shopFullId;
    private String status;
    private int fullId;
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

    public int getShopFullId() {
        return shopFullId;
    }

    public void setShopFullId(int shopFullId) {
        this.shopFullId = shopFullId;
    }

    public int getFullId() {
        return fullId;
    }

    public void setFullId(int fullId) {
        this.fullId = fullId;
    }

}
