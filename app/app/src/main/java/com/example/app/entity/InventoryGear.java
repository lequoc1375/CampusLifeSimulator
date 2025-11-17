package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory_gear")
public class InventoryGear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_gear_id")
    private Integer invenGearId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "gear_id")
    private GearAccessories gear;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;



    public Integer getInvenGearId() {
        return invenGearId;
    }

    public void setInvenGearId(Integer invenGearId) {
        this.invenGearId = invenGearId;
    }

    public GearAccessories getGear() {
        return gear;
    }

    public void setGear(GearAccessories gear) {
        this.gear = gear;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}