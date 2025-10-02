package com.example.app.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RequirementsDTOResponse {
    private Integer requirementId;
    private String name;
    private String field;
    private Double minRequire;

    public Double getMinRequire() {
        return minRequire;
    }

    public void setMinRequire(Double minRequire) {
        this.minRequire = minRequire;
    }

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

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

}
