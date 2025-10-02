package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShopFaceAccessories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_face_id")
    private int shopFaceId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "face_id")
    private FaceAccessories faceAccessories;

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

    public int getShopFaceId() {
        return shopFaceId;
    }

    public void setShopFaceId(int shopFaceId) {
        this.shopFaceId = shopFaceId;
    }

    public FaceAccessories getFaceAccessories() {
        return faceAccessories;
    }

    public void setFaceAccessories(FaceAccessories faceAccessories) {
        this.faceAccessories = faceAccessories;
    }
}
