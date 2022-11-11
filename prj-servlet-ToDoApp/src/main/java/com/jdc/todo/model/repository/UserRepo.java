package com.jdc.todo.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdc.todo.model.entity.User;

public class UserRepo {
	
	private static UserRepo INSTANCE;
	
	private UserRepo() {}
	
	public static UserRepo getInstance() {
		if(null == INSTANCE)
			INSTANCE = new UserRepo();
		return INSTANCE;
	}
	
	public User findUser(String loginId, String password) {
		
		String sql = """
				select * from user where login_id = ?
				""";
		
		try(Connection conn = DatabaseConnector.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				return new User(rs.getString("login_id"),
						rs.getString("password"),
						rs.getString("username"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}





