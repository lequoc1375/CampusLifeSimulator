package com.example.app.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RequirementsDTORequest {
    private String name;
    private String field;
    private Double minRequire;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Double getMinRequire() {
        return minRequire;
    }

    public void setMinRequire(Double minRequire) {
        this.minRequire = minRequire;
    }
}
