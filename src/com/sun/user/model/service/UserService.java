package com.sun.user.model.service;

import static com.sun.common.JDBCTemplate.close;
import static com.sun.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.sun.user.model.dao.UserDao;
import com.sun.user.model.vo.User;
public class UserService {

	public User loginUser(String userId, String userPwd) {
		Connection conn = getConnection();
		String tableName="";
		if( Character.toUpperCase(userId.charAt(0))  =='P') {
			tableName="Professors";
		}
		else if( Character.toUpperCase(userId.charAt(0))  =='A') {
			tableName="Admin";
		}
		else {
			tableName="Student";
		}
		System.out.println(tableName);
		User loginUser = new UserDao().loginUser(conn, userId, userPwd,tableName);
		close(conn);
		return loginUser;
	}

	public User selectFindUser(String userName, String userEmail,String tableName) {
		Connection conn = getConnection();
		
		User findUser = new UserDao().selectFindUser(conn, userName,userEmail, tableName);
		close(conn);
		return findUser;
	}

	public User selectUpdateUser(User user, String tableName) {
		Connection conn = getConnection();
		
		User resetUser = new UserDao().selectUpdateUser(conn, user, tableName);
		close(conn);
		return resetUser;
	}
	
	public int updateUserPwd(User user,String tableName) {
		Connection conn = getConnection();
		
		int result = new UserDao().updateUserPwd(conn, user,tableName);
		close(conn);
		return result;
	}

	public int updateUserNewPwd(String userId,String userPwd,String tableName) {
		Connection conn = getConnection();
		
		int result = new UserDao().updateUserNewPwd(conn, userId,userPwd,tableName);
		close(conn);
		return result;
	}


}
