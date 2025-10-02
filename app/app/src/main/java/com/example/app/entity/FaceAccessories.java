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
@Table(name = "face_accessories")
public class FaceAccessories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "face_id")
    private Integer faceId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "price", precision = 10)
    private Double price;

    public List<ShopFaceAccessories> getShopFaceAccessories() {
        return shopFaceAccessories;
    }

    public void setShopFaceAccessories(List<ShopFaceAccessories> shopFaceAccessories) {
        this.shopFaceAccessories = shopFaceAccessories;
    }

    @Column(name = "categories", length = 50)
    private String categories;

    @OneToMany(mappedBy = "faceAccessories", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ShopFaceAccessories> shopFaceAccessories;

    public Integer getFaceId() {
        return faceId;
    }

    public void setFaceId(Integer faceId) {
        this.faceId = faceId;
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
