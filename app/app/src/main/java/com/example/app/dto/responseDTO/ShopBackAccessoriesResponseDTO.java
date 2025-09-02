package com.example.app.dto.responseDTO;

public class ShopBackAccessoriesResponseDTO {
    private int shopBackId;
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

    public int getShopBackId() {
        return shopBackId;
    }

    public void setShopBackId(int shopBackId) {
        this.shopBackId = shopBackId;
    }

    public int getBackId() {
        return backId;
    }

    public void setBackId(int backId) {
        this.backId = backId;
    }

}
