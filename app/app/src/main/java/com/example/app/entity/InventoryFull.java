package com.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_full")
public class InventoryFull {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_full_id")
    private Integer invenFullId;

    @ManyToOne
    @JoinColumn(name = "full_id")
    private FullCloth fullCloth;

    public Integer getInvenFullId() {
        return invenFullId;
    }

    public void setInvenFullId(Integer invenFullId) {
        this.invenFullId = invenFullId;
    }

    public FullCloth getFullCloth() {
        return fullCloth;
    }

    public void setFullCloth(FullCloth fullCloth) {
        this.fullCloth = fullCloth;
    }
}