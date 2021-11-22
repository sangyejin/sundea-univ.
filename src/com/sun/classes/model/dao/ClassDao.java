package com.sun.classes.model.dao;

import static com.sun.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.sun.classes.model.vo.Classes;
import com.sun.classes.model.vo.PageInfoclass;
import com.sun.common.CommonDao;
import com.sun.student.model.vo.PageInfo;

public class ClassDao {
	Properties prop;
	public ClassDao() {
		// TODO Auto-generated constructor stub
		String fileName = Classes.class.getResource("/sql/classes/professorsClass-query.properties").getPath();
		prop= new CommonDao().propLoad(fileName);
	}
	
	//userId

	public ArrayList<Classes> selectClassList(Connection conn, String userId, String cName, PageInfo pi) {
	      ArrayList<Classes> list=new ArrayList<Classes>();
	      PreparedStatement pstmt=null;
	      ResultSet rset=null;
	      String sql=prop.getProperty("selectClass");
	      
	      int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
	      int endRow = startRow + pi.getBoardLimit() - 1;
	      System.out.println(sql);
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         pstmt.setString(2,  cName);
	         
	         pstmt.setInt(3, startRow);
	         pstmt.setInt(4, endRow);
	         
	         System.out.println(cName);
	         rset= pstmt.executeQuery();
	         
	         while(rset.next()) {
	            Classes c = new Classes(
	                     rset.getString("CLASS_NO"),
	                     rset.getString("CLASS_NAME"),
	                     rset.getString("CLASS_PLACE"),
	                     rset.getString("CLASS_TYPE_NAME"),
	                     rset.getString("P_ID"),
	                     rset.getInt("CLASS_YEAR"),
	                     rset.getInt("CLASS_SEMESTER")
	                  );
	            list.add(c);
	         }
	         
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	         
	      }

	      return list;
	   }

	//	userId와 현재 연도, 학기에 따른 클래스
	public ArrayList<Classes> selectClassByYearAndSemester(Connection conn, String userId,int year, int semester) {
		ArrayList<Classes> list=new ArrayList<Classes>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("selectClassListYearAndSemester");
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2,year);
			pstmt.setInt(3, semester);
			
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				Classes c = new Classes();
				c.setClassNo(rset.getString("CLASS_NO"));
				c.setClassName(rset.getString("CLASS_NAME"));
				list.add(c);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		return list;
	}

	public int getListCount(Connection conn,String userId) {
		int listCount = 0;

		PreparedStatement pstmt=null;
		ResultSet rset = null;

		String sql = prop.getProperty("getListCount");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset= pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
		}

		return listCount;
	}
	
	//합친부분
	public ArrayList<Classes> selectClass(Connection conn, String pId) {
		ArrayList<Classes> list=new ArrayList<Classes>();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("adminClass");
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pId);
			
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				Classes c = new Classes(
							rset.getString("CLASS_NO"),
							rset.getString("CLASS_NAME"),
							rset.getString("CLASS_PLACE"),
							rset.getInt("CLASS_TYPE_NO"),
							rset.getString("P_ID"),
							rset.getInt("CLASS_YEAR"),
							rset.getInt("CLASS_SEMESTER")
						);
				System.out.println(c.getClassNo());
				list.add(c);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}

		return list;
	}
	
	public int getListAdmin(Connection conn) {
		int listCount = 0;

		Statement stmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("getListadmin");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
		}

		return listCount;
	}
	
	public ArrayList<Classes> classList(Connection conn, PageInfoclass pi) {
		ArrayList<Classes> list = new ArrayList<Classes>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("classList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Classes(
						rset.getString("CLASS_NO"),
						rset.getString("CLASS_NAME"),
						rset.getString("CLASS_PLACE"),
						rset.getString("CLASS_TYPE_NAME"),
						rset.getString("P_NAME"),
						rset.getInt("CLASS_YEAR"),
						rset.getInt("CLASS_SEMESTER"),
						rset.getInt("CREDIT")

						));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return list;	
		}

	public Classes searchClasses(Connection conn, String search) {
		Classes classes = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchClass");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				classes = new Classes(
						rset.getString("CLASS_NO")
						,rset.getString("CLASS_NAME")
						,rset.getString("CLASS_PLACE")
						,rset.getString("CLASS_TYPE_NAME")
						,rset.getString("P_NAME")
						,rset.getInt("CLASS_YEAR")
						,rset.getInt("CLASS_SEMESTER")
						,rset.getInt("CREDIT")

						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return classes;
	}

	public int insertClasses(Connection conn, Classes classes) {
		int result=0;
		PreparedStatement pstmt= null;
		String sql = prop.getProperty("insertClass");
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, classes.getClassNo());
			pstmt.setString(2, classes.getClassName());
			pstmt.setString(3, classes.getClassPlace());
			pstmt.setInt(4, classes.getClassTypeNo());
			pstmt.setString(5, classes.getpId());
			pstmt.setInt(6, classes.getClassYear());
			pstmt.setInt(7, classes.getClassSemester());
			pstmt.setInt(8, classes.getCredit());

			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int classNoCheck(Connection conn, String classNo) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("classNoCheck");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, classNo);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				result=rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
				
		return result;
	}

	public int deleteClasses(Connection conn, String classNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteClass");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
      e.printStackTrace();
		} finally {
			close(pstmt);
		}
      
      return result;
	}

	public int updateStudent(Connection conn, String changeNO, String changeName) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateStudent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, changeName);
			pstmt.setString(2, changeNO);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int pIdCheck(Connection conn, String pId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("pIdCheck");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);

		}

		return result;
	}

}
