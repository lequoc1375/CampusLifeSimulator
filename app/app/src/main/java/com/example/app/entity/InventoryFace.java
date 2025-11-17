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
@Table(name = "inventory_face")
public class InventoryFace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inven_face_id")
    private Integer invenFaceId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "face_id")
    private FaceAccessories face;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Integer getInvenFaceId() {
        return invenFaceId;
    }

    public void setInvenFaceId(Integer invenFaceId) {
        this.invenFaceId = invenFaceId;
    }

    public FaceAccessories getFace() {
        return face;
    }

    public void setFace(FaceAccessories face) {
        this.face = face;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}