package com.sun.admin.model.vo;

import com.sun.user.model.vo.User;

public class Admin extends User{
	private String userId;
	private String userPwd;
	private String userName;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String userId, String userPwd, String userName) {
		super(userId,userPwd,userName);
	}
	
	@Override
	public String toString() {
		return "Admin["+super.toString()+"]";
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
