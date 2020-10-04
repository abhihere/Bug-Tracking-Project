package com.code.service;

import java.sql.SQLException;

import com.code.bean.User;

public interface UserService {

	User validateUser(String userName, String password) throws SQLException;

}
