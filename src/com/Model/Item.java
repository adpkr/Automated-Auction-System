package com.Model;

import java.sql.Date;

public class Item {
	

	private String itemName;
	private int itemQuantity;
	private int itemPrice;
	private String itemDate;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String itemName, int itemQuantity, int itemPrice, String itemDate) {
		super();
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.itemDate = itemDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDate() {
		return itemDate;
	}

	public void setItemDate(String itemDate) {
		this.itemDate = itemDate;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", itemPrice=" + itemPrice
				+ ", itemDate=" + itemDate + "]";
	}
	
	

	
	
	

}
