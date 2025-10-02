package com.example.app.dto.responseDTO;

public class ShopLowerClothResponseDTO {
    private int shopLowerId;
    private String status;
    private int lowerId;
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

    public int getShopLowerId() {
        return shopLowerId;
    }

    public void setShopLowerId(int shopLowerId) {
        this.shopLowerId = shopLowerId;
    }

    public int getLowerId() {
        return lowerId;
    }

    public void setLowerId(int lowerId) {
        this.lowerId = lowerId;
    }

}
