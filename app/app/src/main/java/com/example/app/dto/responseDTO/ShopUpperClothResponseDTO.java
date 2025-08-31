package com.example.app.dto.responseDTO;

public class ShopUpperClothResponseDTO {
    private int shopUpperId;
    private String status;
    private int upperId;
    private int shopId;

    public int getShopUpperId() {
        return shopUpperId;
    }

    public void setShopUpperId(int shopUpperId) {
        this.shopUpperId = shopUpperId;
    }

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

    public int getUpperId() {
        return upperId;
    }

    public void setUpperId(int upperId) {
        this.upperId = upperId;
    }

}
