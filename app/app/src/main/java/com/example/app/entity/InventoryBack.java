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
@Table(name = "inventory_back")
public class InventoryBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_back_id")
    private Integer invenBackId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "back_id")
    private BackAccessories back; 

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;


    public Integer getInvenBackId() {
        return invenBackId;
    }

    public void setInvenBackId(Integer invenBackId) {
        this.invenBackId = invenBackId;
    }

    public BackAccessories getBack() {
        return back;
    }

    public void setBack(BackAccessories back) {
        this.back = back;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}