package com.example.app.dto.responseDTO;

public class ShopFaceAccessoriesResponseDTO {
    private int shopFaceId;
    private String status;
    private int faceId;
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

    public int getShopFaceId() {
        return shopFaceId;
    }

    public void setShopFaceId(int shopFaceId) {
        this.shopFaceId = shopFaceId;
    }

    public int getFaceId() {
        return faceId;
    }

    public void setFaceId(int faceId) {
        this.faceId = faceId;
    }

}
