//Author : Akanksha Shrivastava
//Purpose : User class, parent of ProjectManager, Tester and Developer, contains details about all users.

package com.code.bean;

abstract public class User {
		
	//data members
	int userId;
	private String userName;
	private String email;
	private String typeOfUser;
	
	//default constructor
	public User() {
		
		userId = 0;
		userName = null;
		email = null;
		typeOfUser = null;
	}
	
	//parameterized constructor
	public User(int userId, String userName, String email, String typeOfUser) {
	
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.typeOfUser = typeOfUser;
	}

	//setter and getter methods
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	//Overriding toString method
	@Override
	public String toString() {
		return "User ID = " + userId + "\nUser Name = " + userName + "\nE-mail = " + email + "\nType Of User = " + typeOfUser;
	}
}
