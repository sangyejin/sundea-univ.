package com.sun.user.model.vo;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String userPwd, String userName) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
	public User(String userId, String userPwd, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "userId="+userId+", userPwd"+userPwd+", userName"+userName;
		
	}
	
	
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
