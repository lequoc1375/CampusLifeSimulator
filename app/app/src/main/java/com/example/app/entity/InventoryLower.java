package com.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_lower")
public class InventoryLower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_lower_id")
    private Integer invenLowerId;

    @ManyToOne
    @JoinColumn(name = "lower_id")
    private LowerCloth lowerCloth;

    public Integer getInvenLowerId() {
        return invenLowerId;
    }

    public void setInvenLowerId(Integer invenLowerId) {
        this.invenLowerId = invenLowerId;
    }

    public LowerCloth getLowerCloth() {
        return lowerCloth;
    }

    public void setLowerCloth(LowerCloth lowerCloth) {
        this.lowerCloth = lowerCloth;
    }
}
