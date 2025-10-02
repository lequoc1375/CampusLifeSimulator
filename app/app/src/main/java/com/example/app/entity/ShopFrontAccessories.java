package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShopFrontAccessories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_front_id")
    private int shopFrontId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "front_id")
    private FrontAccessories frontAccessories;

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

    public int getShopFrontId() {
        return shopFrontId;
    }

    public void setShopFrontId(int shopFrontId) {
        this.shopFrontId = shopFrontId;
    }

    public FrontAccessories getFrontAccessories() {
        return frontAccessories;
    }

    public void setFrontAccessories(FrontAccessories frontAccessories) {
        this.frontAccessories = frontAccessories;
    }
}
