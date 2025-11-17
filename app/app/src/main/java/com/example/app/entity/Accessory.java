package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accessories")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessory_id")
    private Integer accessoryId;

    
    @ManyToOne
    @JoinColumn(name = "head_id")
    private InventoryHead head;

    @ManyToOne
    @JoinColumn(name = "face_id")
    private InventoryFace face;

    @ManyToOne
    @JoinColumn(name = "back_id")
    private InventoryBack back;

    @ManyToOne
    @JoinColumn(name = "front_id")
    private InventoryFront front;
    
    @ManyToOne
    @JoinColumn(name = "gear_id")
    private InventoryGear gear;

    
    public Integer getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    public InventoryHead getHead() {
        return head;
    }

    public void setHead(InventoryHead head) {
        this.head = head;
    }

    public InventoryFace getFace() {
        return face;
    }

    public void setFace(InventoryFace face) {
        this.face = face;
    }

    public InventoryBack getBack() {
        return back;
    }

    public void setBack(InventoryBack back) {
        this.back = back;
    }

    public InventoryFront getFront() {
        return front;
    }

    public void setFront(InventoryFront front) {
        this.front = front;
    }

    public InventoryGear getGear() {
        return gear;
    }

    public void setGear(InventoryGear gear) {
        this.gear = gear;
    }
}