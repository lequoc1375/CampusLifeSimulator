package com.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "foot_cloth")
public class FootCloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foot_id")
    private Integer footId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "price", precision = 10)
    private Double price;

    @Column(name = "categories", length = 50)
    private String categories;

    public Integer getFootId() {
        return footId;
    }

    public void setFootId(Integer footId) {
        this.footId = footId;
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
