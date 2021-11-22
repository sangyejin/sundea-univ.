package com.sun.user.model.dao;

import static com.sun.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.sun.common.CommonDao;
import com.sun.user.model.vo.User;

public class UserDao {
	private Properties prop;
	public UserDao() {
		// TODO Auto-generated constructor stub
		String fileName = UserDao.class.getResource("/sql/user/user-qeury.properties").getPath();
		prop= new CommonDao().propLoad(fileName);
	}



	public User loginUser(Connection conn, String userId, String userPwd,String tableName) {
		User loginUser=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		System.out.println(tableName);
		String sql=prop.getProperty("select"+tableName);
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser= new User(
							rset.getString(tableName.charAt(0)+"_ID"),
							rset.getString(tableName.charAt(0)+"_PWD"),
							rset.getString(tableName.charAt(0)+"_NAME")
						);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}

		return loginUser;
	}



	public User selectFindUser(Connection conn, String userName, String userEmail,String tableName) {
		User findUser=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectFind"+tableName);
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				findUser= new User();
				findUser.setUserEmail(rset.getString(tableName.charAt(0)+"_EMAIL"));
				findUser.setUserId(rset.getString(tableName.charAt(0)+"_ID"));
				findUser.setUserName(rset.getString(tableName.charAt(0)+"_NAME"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}

		return findUser;
	}



	public int updateUserPwd(Connection conn, User user,String tableName) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updatePwd"+tableName);
//		updatePwdStudent=UPDATE STUDENT SET S_PWD=? WHERE S_ID=?
//		updatePwdStudent=UPDATE PROFESSORS SET P_PWD=? WHERE P_ID=?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserId());
			pstmt.setString(2,user.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}



	public User selectUpdateUser(Connection conn, User user, String tableName) {
		User resetUser=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectResetPwd"+tableName);
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserEmail());
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				resetUser= new User();
				resetUser.setUserEmail(rset.getString(tableName.charAt(0)+"_EMAIL"));
				resetUser.setUserId(rset.getString(tableName.charAt(0)+"_ID"));
				resetUser.setUserName(rset.getString(tableName.charAt(0)+"_NAME"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}

		return resetUser;
	}



	public User selectUserPwd(Connection conn, String userId, String userPwd, String tableName) {
		User updateUser=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectUserPwd"+tableName);
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tableName);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				updateUser= new User();
				updateUser.setUserId(rset.getString(tableName.charAt(0)+"_ID"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}

		return updateUser;
	}
	
	public int updateUserNewPwd(Connection conn,String userId,String userPwd,String tableName) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateNewPwd"+tableName);
//		updatePwdStudent=UPDATE STUDENT SET S_PWD=? WHERE S_ID=?
//		updatePwdStudent=UPDATE PROFESSORS SET P_PWD=? WHERE P_ID=?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userPwd);
			pstmt.setString(2,userId);
			result = pstmt.executeUpdate();
			System.out.println("dao::"+userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
}
