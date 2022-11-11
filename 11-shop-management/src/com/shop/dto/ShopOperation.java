package com.shop.dto;

public enum ShopOperation {
	
	Add ,Update ,Delete, ShowAll, Search;
	public String toString() {
		return ordinal()+1+"."+name();
	}
}
