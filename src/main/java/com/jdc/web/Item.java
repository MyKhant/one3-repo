package com.jdc.web;

public class Item {
	private String name;
	private double price;
	private int quantity;
	
	public Item() {
		
	}
	public Item(String line) {
		String[] arr=line.split("\t");
		name=arr[0];
		price = Double.parseDouble(arr[1]);
		quantity=Integer.parseInt(arr[2]);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
