package com.sun.professors.model.vo;

import com.sun.user.model.vo.User;

public class Professors extends User {
	private String userId;
	private String userPwd;
	private String userName;
	private String cNo;
	private String cName;
	private String pPhone;
	private String pEmail;
	
	public Professors() {
		// TODO Auto-generated constructor stub
	}

	public Professors(String userId, String userPwd, String userName, String cNo, String pPhone, String pEmail) {
		super(userId,userPwd,userName);
		this.cNo = cNo;
		this.pPhone = pPhone;
		this.pEmail = pEmail;
	}
	
	@Override
	public String toString() {
		return "professors["+super.toString()+" cNo"+cNo+" cName"+cName+" pPhone"+pPhone+" pEmail"+pEmail+"]";
	}
	
	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
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

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getpPhone() {
		return pPhone;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	public String getpEmail() {
		return pEmail;
	}

	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	//합친부분
	public Professors(String userId, String userName, String cNo, String pPhone, String pEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.cNo = cNo;
		this.pPhone = pPhone;
		this.pEmail = pEmail;
		
	
	} //관리자-교수 목록

	
	
}
