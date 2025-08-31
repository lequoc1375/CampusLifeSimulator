package com.example.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int shopId;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ShopUpperCloth> shopUpperList;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ShopLowerCloth> shopLowerList;
    
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ShopFootCloth> shopFootList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public List<ShopUpperCloth> getShopUpperList() {
        return shopUpperList;
    }

    public void setShopUpperList(List<ShopUpperCloth> shopUpperList) {
        this.shopUpperList = shopUpperList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShopLowerCloth> getShopLowerList() {
        return shopLowerList;
    }

    public void setShopLowerList(List<ShopLowerCloth> shopLowerList) {
        this.shopLowerList = shopLowerList;
    }

}
