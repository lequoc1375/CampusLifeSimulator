package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShopUpperCloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_upper_id")
    private int shopUpperId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "upper_id")
    private UpperCloth upperCloth;

    public int getShopUpperId() {
        return shopUpperId;
    }

    public void setShopUpperId(int shopUpperId) {
        this.shopUpperId = shopUpperId;
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

    public UpperCloth getUpperCloth() {
        return upperCloth;
    }

    public void setUpperCloth(UpperCloth upperCloth) {
        this.upperCloth = upperCloth;
    }

}
