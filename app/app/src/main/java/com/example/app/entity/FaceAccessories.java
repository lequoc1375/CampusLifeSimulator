package com.example.app.entity;

import jakarta.persistence.*;

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

    @Column(name = "categories", length = 50)
    private String categories;

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
