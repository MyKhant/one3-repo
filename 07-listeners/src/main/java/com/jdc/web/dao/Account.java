package com.jdc.web.dao;

public class Account {
	private String loginId;
	private String password
	;
	public Account(String loginId, String password) {
		this.loginId = loginId;
		this.password = password;
	}
	public String getLoginId() {
		return loginId;
	}
	public String getPassword() {
		return password;
	}
	
}
