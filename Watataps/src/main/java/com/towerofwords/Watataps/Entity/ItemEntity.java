package com.towerofwords.Watataps.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemID;

    private String imagePath;
    private String itemName;

    public ItemEntity() {
        // Default constructor
    }

    public ItemEntity(String imagePath, String itemName) {
        this.imagePath = imagePath;
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}