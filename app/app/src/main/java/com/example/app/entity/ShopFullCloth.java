package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShopFullCloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_full_id")
    private int shopFullId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "full_id")
    private FullCloth fullCloth;

    public int getShopFullId() {
        return shopFullId;
    }

    public void setShopFullId(int shopFullId) {
        this.shopFullId = shopFullId;
    }

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

    public FullCloth getFullCloth() {
        return fullCloth;
    }

    public void setFullCloth(FullCloth fullCloth) {
        this.fullCloth = fullCloth;
    }
}
