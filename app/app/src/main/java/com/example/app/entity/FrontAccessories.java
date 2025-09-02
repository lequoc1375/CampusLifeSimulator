package com.example.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "front_accessories")
public class FrontAccessories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "front_id")
    private Integer frontId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "price", precision = 10)
    private Double price;

    @Column(name = "categories", length = 50)
    private String categories;

    @OneToMany(mappedBy = "frontAccessories", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ShopFrontAccessories> shopFrontAccessories;

    public List<ShopFrontAccessories> getShopFrontAccessories() {
        return shopFrontAccessories;
    }

    public void setShopFrontAccessories(List<ShopFrontAccessories> shopFrontAccessories) {
        this.shopFrontAccessories = shopFrontAccessories;
    }

    public Integer getFrontId() {
        return frontId;
    }

    public void setFrontId(Integer frontId) {
        this.frontId = frontId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
