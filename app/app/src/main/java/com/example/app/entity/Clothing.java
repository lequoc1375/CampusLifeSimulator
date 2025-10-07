package com.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clothing")
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_id")
    private Integer clothId;

    @ManyToOne
    @JoinColumn(name = "inven_upper_id")
    private InventoryUpper invenUpper;

    @ManyToOne
    @JoinColumn(name = "inven_lower_id")
    private InventoryLower invenLower;

    @ManyToOne
    @JoinColumn(name = "inven_full_id")
    private InventoryFull invenFull;

    @ManyToOne
    @JoinColumn(name = "inven_foot_id")
    private InventoryFoot invenFoot;

    public Integer getClothId() {
        return clothId;
    }

    public void setClothId(Integer clothId) {
        this.clothId = clothId;
    }

    public InventoryUpper getInvenUpper() {
        return invenUpper;
    }

    public void setInvenUpper(InventoryUpper invenUpper) {
        this.invenUpper = invenUpper;
    }

    public InventoryLower getInvenLower() {
        return invenLower;
    }

    public void setInvenLower(InventoryLower invenLower) {
        this.invenLower = invenLower;
    }

    public InventoryFull getInvenFull() {
        return invenFull;
    }

    public void setInvenFull(InventoryFull invenFull) {
        this.invenFull = invenFull;
    }

    public InventoryFoot getInvenFoot() {
        return invenFoot;
    }

    public void setInvenFoot(InventoryFoot invenFoot) {
        this.invenFoot = invenFoot;
    }
}