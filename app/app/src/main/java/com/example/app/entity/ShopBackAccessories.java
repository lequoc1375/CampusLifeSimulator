package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShopBackAccessories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_back_id")
    private int shopBackId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "back_id")
    private BackAccessories backAccessories;

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

    public int getShopBackId() {
        return shopBackId;
    }

    public void setShopBackId(int shopBackId) {
        this.shopBackId = shopBackId;
    }

    public BackAccessories getBackAccessories() {
        return backAccessories;
    }

    public void setBackAccessories(BackAccessories backAccessories) {
        this.backAccessories = backAccessories;
    }
}
