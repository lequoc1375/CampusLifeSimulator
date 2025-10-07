package com.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_upper")
public class InventoryUpper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_upper_id")
    private Integer invenUpperId;

    @ManyToOne
    @JoinColumn(name = "upper_id")
    private UpperCloth upperCloth;

    // Nếu bạn có entity Inventory thì thêm vào
    // @ManyToOne
    // @JoinColumn(name = "inventory_id")
    // private Inventory inventory;

    public Integer getInvenUpperId() {
        return invenUpperId;
    }

    public void setInvenUpperId(Integer invenUpperId) {
        this.invenUpperId = invenUpperId;
    }

    public UpperCloth getUpperCloth() {
        return upperCloth;
    }

    public void setUpperCloth(UpperCloth upperCloth) {
        this.upperCloth = upperCloth;
    }
}