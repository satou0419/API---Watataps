package com.towerofwords.Watataps.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_user_item")
public class UserItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userItemID;
    
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "itemID")
    private ItemEntity item;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userID")
    private UserDetailsEntity userDetails;

    public UserItemEntity() {
        super();
    }

    public UserItemEntity(int userItemID, int quantity, ItemEntity item, UserDetailsEntity userDetails) {
        super();
        this.userItemID = userItemID;
        this.quantity = quantity;
        this.item = item;
        this.userDetails = userDetails;
    }

    public int getUserItemID() {
        return userItemID;
    }

    public void setUserItemID(int userItemID) {
        this.userItemID = userItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public UserDetailsEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsEntity userDetails) {
        this.userDetails = userDetails;
    }
}
