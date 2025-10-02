package com.example.app.dto.responseDTO;

public class ShopGearAccessoriesResponseDTO {
    private int shopGearId;
    private String status;
    private int gearId;
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

    public int getShopGearId() {
        return shopGearId;
    }

    public void setShopGearId(int shopGearId) {
        this.shopGearId = shopGearId;
    }

    public int getGearId() {
        return gearId;
    }

    public void setGearId(int gearId) {
        this.gearId = gearId;
    }

}
