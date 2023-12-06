package com.towerofwords.Watataps.Entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_item")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemID;
	private String imagePath;
	private String itemName;
	private String itemDescription;
	private int price;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<UserItemEntity> userItems;

	
	public ItemEntity() {
		super();
	}
	
	
	public ItemEntity(int itemID, String imagePath, String itemName, String itemDescription, int price,
			List<UserItemEntity> userItems) {
		super();
		this.itemID = itemID;
		this.imagePath = imagePath;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.price = price;
		this.userItems = userItems;
	}
	
	


	public String getItemDescription() {
		return itemDescription;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getItemID() {
		return itemID;
	}
	
	
	public ItemEntity(int itemID, String imagePath, String itemName, List<UserItemEntity> userItems) {
		super();
		this.itemID = itemID;
		this.imagePath = imagePath;
		this.itemName = itemName;
		this.userItems = userItems;
	}
	public List<UserItemEntity> getUserItems() {
		return userItems;
	}
	public void setUserItems(List<UserItemEntity> userItems) {
		this.userItems = userItems;
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