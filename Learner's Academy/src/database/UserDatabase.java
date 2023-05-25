package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.User;

public class UserDatabase {
	
	public boolean validateUser(String email, String password) throws SQLException
	{
		boolean isValid = false;
		String sql = "select password from user where email=?";

		Connection conn = DBConnection.dbConn();
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, email);
		ResultSet rs = stat.executeQuery();
		if(rs.next()) {
			String pass = rs.getString(1);
			if(pass.equals(password))
				isValid = true;
		}
		
		return isValid;
	}

	public List<User> getAllUsers() throws SQLException
	{
		List<User> users = new ArrayList<User>();

		String sql = "select * from user";

		// 1. DB connection 
		Connection conn = DBConnection.dbConn();
		//2. create the statememt
		Statement stat = conn.createStatement();
		// 3. execute the query
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			User user = new User();
			user.setEmail(rs.getString(1));
			user.setPhone(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setCity(rs.getString(4));
			users.add(user);
		}
		return users;
	}
}
