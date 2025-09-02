package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShopGearAccessories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_gear_id")
    private int shopGearId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "gear_id")
    private GearAccessories gearAccessories;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getShopGearId() {
        return shopGearId;
    }

    public void setShopGearId(int shopGearId) {
        this.shopGearId = shopGearId;
    }

    public GearAccessories getGearAccessories() {
        return gearAccessories;
    }

    public void setGearAccessories(GearAccessories gearAccessories) {
        this.gearAccessories = gearAccessories;
    }
}
