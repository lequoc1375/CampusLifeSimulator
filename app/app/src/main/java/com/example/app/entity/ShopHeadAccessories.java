package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShopHeadAccessories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_head_id")
    private int shopHeadId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "head_id")
    private HeadAccessories headAccessories;

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

    public int getShopHeadId() {
        return shopHeadId;
    }

    public void setShopHeadId(int shopHeadId) {
        this.shopHeadId = shopHeadId;
    }

    public HeadAccessories getHeadAccessories() {
        return headAccessories;
    }

    public void setHeadAccessories(HeadAccessories headAccessories) {
        this.headAccessories = headAccessories;
    }
}
