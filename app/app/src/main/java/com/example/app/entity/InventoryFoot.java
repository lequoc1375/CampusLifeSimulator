package com.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_foot")
public class InventoryFoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_foot_id")
    private Integer invenFootId;

    @ManyToOne
    @JoinColumn(name = "foot_id")
    private FootCloth footCloth;

    public Integer getInvenFootId() {
        return invenFootId;
    }

    public void setInvenFootId(Integer invenFootId) {
        this.invenFootId = invenFootId;
    }

    public FootCloth getFootCloth() {
        return footCloth;
    }

    public void setFootCloth(FootCloth footCloth) {
        this.footCloth = footCloth;
    }
}
