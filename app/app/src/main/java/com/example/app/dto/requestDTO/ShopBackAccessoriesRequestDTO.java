package com.example.app.dto.requestDTO;

public class ShopBackAccessoriesRequestDTO {
    private String status;
    private int backId;
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

    public int getBackId() {
        return backId;
    }

    public void setBackId(int backId) {
        this.backId = backId;
    }
}
