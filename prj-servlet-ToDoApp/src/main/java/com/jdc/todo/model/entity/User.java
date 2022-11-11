package com.jdc.todo.model.entity;

public class User {

	private int id;
	private String loginId;
	private String password;
	private String username;

	public User(String loginId, String password, String username) {
		this.loginId = loginId;
		this.password = password;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

}
