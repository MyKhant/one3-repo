package com.jdc.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.jdc.web.dao.User;

public class UserModel implements BaseModel<User>{
	
	private List<User> list;
	private static UserModel INSTANCE;
	
	private UserModel() {
		list=new ArrayList<>();
	}
	public static UserModel getInstance() {
		return INSTANCE == null ? INSTANCE = new UserModel() : INSTANCE;
	}
	@Override
	public void add(User t) {
		if(Objects.isNull(t))
			throw new UserException("User can't be null");
		
		list.add(t);
	}

	@Override
	public void update(int id, User t) {
		
	}

	@Override
	public void delete(int id) {
		if(id < 0)
			throw new UserException("ID must be greater than zero!");
		
		list.remove(findIndex(id));
	}

	@Override
	public User findById(int id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<>(list);
	}

	private int findIndex(int id) {
		int index = -1;
		for(User user:list) {
			if(user.getId()==id)
				index=list.indexOf(user);
		}
		return index;
	}
	
}
