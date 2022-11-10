package com.jdc.mkk.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.jdc.mkk.model.Role;
import com.jdc.mkk.model.User;

public class UserService {
	private static final String URL="jdbc:mysql://localhost:3306/shop_db";
	private static final String USER="root";
	private static final String PASS="root";
	
	public User checkUser(String name) {
		String sql="select * from user_tbl where name=?";
		try (
				Connection con=DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement stmt=con.prepareStatement(sql);
				){
			System.out.println("db test");
			stmt.setString(1, name);
			var rs=stmt.executeQuery();
			
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
				
				return u;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
