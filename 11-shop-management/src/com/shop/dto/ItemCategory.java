package com.shop.dto;

public enum ItemCategory {
	Fruit, Drink, Food, Kitchen;
	@Override
	public String toString(){
		return ordinal()+1+". "+name();
	}
}
