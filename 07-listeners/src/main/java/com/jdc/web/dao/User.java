package com.jdc.web.dao;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	
	public User() {}
	public User(String line) {
		String[] arr=line.split("\t");
		this.id=Integer.parseInt(arr[0]);
		this.firstName=arr[1];
		this.lastName=arr[2];
		this.email=arr[3];
		this.phone=arr[4];
		this.address=arr[5];
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	
}
