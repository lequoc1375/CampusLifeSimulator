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
@Table(name = "inventory_head")
public class InventoryHead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_head_id")
    private Integer invenHeadId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "head_id")
    private HeadAccessories head;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;


    public Integer getInvenHeadId() {
        return invenHeadId;
    }

    public void setInvenHeadId(Integer invenHeadId) {
        this.invenHeadId = invenHeadId;
    }

    public HeadAccessories getHead() {
        return head;
    }

    public void setHead(HeadAccessories head) {
        this.head = head;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}