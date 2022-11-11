package com.shop.repositry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.shop.dto.Item;
import com.shop.dto.ItemCategory;

public class ShopRepositryImpl implements ShopRepositry {
	private static ShopRepositryImpl instance;
	private List<Item> list;
	private static int id;

	@SuppressWarnings("unchecked")
	private ShopRepositryImpl() {
		list = new ArrayList<>();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("item.obj"))) {
			list = (List<Item>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("First Time Read");
		}
	}

	public static ShopRepositryImpl getInstance() {
		return instance = instance == null ? new ShopRepositryImpl() : instance;
	}

	@Override
	public void addOrUpdate(Item item) {
		if (item.getId() == 0) {
			item.setId(++id);
		}
		System.out.println(item);
		list.add(item);
		storeData(list);
	}

	private void storeData(List<Item> list2) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("item.obj"))) {
			out.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		System.out.println("delete");
	}

	@Override
	public List<Item> showAll() {
		return list;
	}

	@Override
	public Item search(int id, String name, int price, int quantity, ItemCategory category) {
		return null;
	}

	@Override
	public Item findById(int id) {
		return null;
	}

}
