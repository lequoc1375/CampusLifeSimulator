package com.example.app.dto.responseDTO;

public class FrontAccessoriesResponseDTO {
    private Integer frontId;
    private String name;
    private String image;
    private Double price;
    private String categories;

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
