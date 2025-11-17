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
@Table(name = "inventory_front")
public class InventoryFront {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_front_id")
    private Integer invenFrontId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "front_id")
    private FrontAccessories front; 

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;


    public Integer getInvenFrontId() {
        return invenFrontId;
    }

    public void setInvenFrontId(Integer invenFrontId) {
        this.invenFrontId = invenFrontId;
    }

    public FrontAccessories getFront() {
        return front;
    }

    public void setFront(FrontAccessories front) {
        this.front = front;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}