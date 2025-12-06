package com.example.app.dto.responseDTO;

public class FullClothResponseDTO {
    private Integer fullId;
    private String name;
    private String imageUrl;
    private Double price;
    private String categories;

    public Integer getFullId() {
        return fullId;
    }

    public void setFullId(Integer fullId) {
        this.fullId = fullId;
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