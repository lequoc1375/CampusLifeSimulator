package com.example.app.dto.responseDTO;



public class LowerClothResponseDTO {
    private Integer lowerId;
    private String name;
    private Double price;
    private String categories;
    private String imageUrl;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getLowerId() {
        return lowerId;
    }

    public void setLowerId(Integer lowerId) {
        this.lowerId = lowerId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}