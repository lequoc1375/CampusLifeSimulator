package com.example.app.dto.responseDTO;

public class ShopHeadAccessoriesResponseDTO {
    private int shopHeadId;
    private String status;
    private int headId;
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

    public int getShopHeadId() {
        return shopHeadId;
    }

    public void setShopHeadId(int shopHeadId) {
        this.shopHeadId = shopHeadId;
    }

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

}
