package com.example.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lower_cloth")
public class LowerCloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lower_id")
    private Integer lowerId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "public_id", length = 255)
    private String publicId;

    @Column(name = "price", precision = 10)
    private Double price;

    @Column(name = "categories", length = 50)
    private String categories;

    @OneToMany(mappedBy = "lowerCloth", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShopLowerCloth> shopLowerCloth;

    public Integer getLowerId() {
        return lowerId;
    }

    public List<ShopLowerCloth> getShopLowerCloth() {
        return shopLowerCloth;
    }

    public void setShopLowerCloth(List<ShopLowerCloth> shopLowerCloth) {
        this.shopLowerCloth = shopLowerCloth;
    }

    public void setLowerId(Integer lowerId) {
        this.lowerId = lowerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
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
