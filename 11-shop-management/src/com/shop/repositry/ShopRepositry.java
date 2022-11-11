package com.shop.repositry;

import java.util.List;

import com.shop.dto.Item;
import com.shop.dto.ItemCategory;

public interface ShopRepositry {
	void addOrUpdate(Item item);
	void delete(int id);
	List<Item> showAll();
	Item search(int id, String name, int price, int quantity, ItemCategory category);
	Item findById(int id);
}
