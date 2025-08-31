package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShopLowerCloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_lower_id")
    private int shopLowerId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "lower_id")
    private LowerCloth lowerCloth;

    public int getShopLowerId() {
        return shopLowerId;
    }

    public void setShopLowerId(int shopLowerId) {
        this.shopLowerId = shopLowerId;
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

    public LowerCloth getLowerCloth() {
        return lowerCloth;
    }

    public void setLowerCloth(LowerCloth lowerCloth) {
        this.lowerCloth = lowerCloth;
    }
}
