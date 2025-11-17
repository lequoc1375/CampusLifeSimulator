package com.example.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "inventory")
    private List<InventoryHead> headItems;
    @JsonManagedReference
    @OneToMany(mappedBy = "inventory")
    private List<InventoryFace> faceItems;

    public List<InventoryHead> getHeadItems() {
        return headItems;
    }

    public void setHeadItems(List<InventoryHead> headItems) {
        this.headItems = headItems;
    }

    public List<InventoryFace> getFaceItems() {
        return faceItems;
    }

    public void setFaceItems(List<InventoryFace> faceItems) {
        this.faceItems = faceItems;
    }

    public List<InventoryBack> getBackItems() {
        return backItems;
    }

    public void setBackItems(List<InventoryBack> backItems) {
        this.backItems = backItems;
    }

    public List<InventoryFront> getFrontItems() {
        return frontItems;
    }

    public void setFrontItems(List<InventoryFront> frontItems) {
        this.frontItems = frontItems;
    }

    public List<InventoryGear> getGearItems() {
        return gearItems;
    }

    public void setGearItems(List<InventoryGear> gearItems) {
        this.gearItems = gearItems;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "inventory")
    private List<InventoryBack> backItems;

    @JsonManagedReference
    @OneToMany(mappedBy = "inventory")
    private List<InventoryFront> frontItems;

    @JsonManagedReference
    @OneToMany(mappedBy = "inventory")
    private List<InventoryGear> gearItems;

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}