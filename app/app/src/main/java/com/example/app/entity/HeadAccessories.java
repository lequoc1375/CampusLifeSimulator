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
@Table(name = "head_accessories")
public class HeadAccessories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "head_id")
    private Integer headId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "price", precision = 10)
    private Double price;

    @Column(name = "categories", length = 50)
    private String categories;

    @OneToMany(mappedBy = "headAccessories", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ShopHeadAccessories> shopHeadAccessories;

    public Integer getHeadId() {
        return headId;
    }

    public void setHeadId(Integer headId) {
        this.headId = headId;
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

    public List<ShopHeadAccessories> getShopHeadAccessories() {
        return shopHeadAccessories;
    }

    public void setShopHeadAccessories(List<ShopHeadAccessories> shopHeadAccessories) {
        this.shopHeadAccessories = shopHeadAccessories;
    }
}
