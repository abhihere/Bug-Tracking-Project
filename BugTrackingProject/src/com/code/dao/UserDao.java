package com.code.dao;

import java.sql.SQLException;

import com.code.bean.User;

public interface UserDao {

	User validateUser(String userName, String password) throws SQLException;

	int addUser(String name, String type, String email) throws SQLException;

}
