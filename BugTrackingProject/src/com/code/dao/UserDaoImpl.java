package com.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.code.bean.User;

public class UserDaoImpl implements UserDao {
	static {
		try {
			con = DBUtil.getMyConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static Connection con;
	
	//authenticate user using userName and password
	@Override
	public User validateUser(String userName, String password) throws SQLException {
		String sql = "select * from login where email = ? and password = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, userName);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			sql = "select * from user where id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, rs.getInt(1));
			ResultSet rs1 = st.executeQuery();
			if(rs1.next()) {
				System.out.println("in rs1");
				return new User(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
			}else {
				return null;
			}
		}else {
			return null;			
		}
	}
	
	//add user into database
	@Override
	public int addUser(String name, String type, String email) throws SQLException {
		String sql = "insert into user (name, email, type) values (?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, name);
		st.setString(2, email);
		st.setString(3, type);
		
		return st.executeUpdate();
	}
	
	

}
