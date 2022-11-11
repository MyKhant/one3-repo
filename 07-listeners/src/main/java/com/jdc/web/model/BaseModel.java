package com.jdc.web.model;

import java.util.List;

public interface BaseModel<T> {
	
	void add(T t);
	void update(int id,T t);
	void delete(int id);
	T findById(int id);
	List<T> findAll();
}
