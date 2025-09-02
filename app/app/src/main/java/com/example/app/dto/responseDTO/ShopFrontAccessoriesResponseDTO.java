package com.example.app.dto.responseDTO;

public class ShopFrontAccessoriesResponseDTO {
    private int shopFrontId;
    private String status;
    private int frontId;
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

    public int getShopFrontId() {
        return shopFrontId;
    }

    public void setShopFrontId(int shopFrontId) {
        this.shopFrontId = shopFrontId;
    }

    public int getFrontId() {
        return frontId;
    }

    public void setFrontId(int frontId) {
        this.frontId = frontId;
    }

}
