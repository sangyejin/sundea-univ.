package com.sun.professors.model.dao;

import static com.sun.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.sun.common.CommonDao;
import com.sun.professors.model.vo.Category;
import com.sun.professors.model.vo.PageInfoprof;
import com.sun.professors.model.vo.Professors;
import com.sun.student.model.vo.PageInfo;
import com.sun.student.model.vo.Student;
import com.sun.student.model.vo.StudentConsulting;

public class ProfessorsDao {
	
	private Properties prop;
	
	public ProfessorsDao() {
		String fileName = Student.class.getResource("/sql/professors/professors-query.properties").getPath();
		prop= new CommonDao().propLoad(fileName);
	}
	
	
	public ArrayList<Student> selectchList(Connection conn, String userId) {
		ArrayList<Student> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectsList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			list = new ArrayList<Student>();
			while (rset.next()) {
				Student s = new Student();
				s.setUserId(rset.getString("S_ID"));
				s.setUserName(rset.getString("S_NAME"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	public ArrayList<StudentConsulting> selectConsultingList(Connection conn, String sId,PageInfo pi) {
		ArrayList<StudentConsulting> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectConsultingList");
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			list = new ArrayList<StudentConsulting>();
			while (rset.next()) {
				StudentConsulting sc = new StudentConsulting();
				sc.setCsNo(rset.getInt("CS_NO"));
				sc.setCsContent(rset.getString("CS_CONTENTS"));
				sc.setCsDate(rset.getDate("CS_DATE"));
				sc.setCsTime(rset.getString("CS_TIME"));
				sc.setCsWay(rset.getString("CS_WAY"));
				sc.setCsType(rset.getString("CS_TYPE"));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}


	public int insertConsulting(Connection conn, StudentConsulting sc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertConsulting");
		
//		insertConsulting=INSERT INTO CONSULTING VALUES
//		(SEQ_CONSULTING.NEXTVAL,     ?,             ?,       ?    ,    ?,     ?,           ?)
//		        CS_NO               S_ID    CS_CONTENTS   CS_DATE  CS_TIME     CS_WAY     CS_TYPE
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sc.getsId());
			pstmt.setString(2,sc.getCsContent());
			pstmt.setDate(3,sc.getCsDate());
			pstmt.setString(4,sc.getCsTime());
			pstmt.setString(5,sc.getCsWay());
			pstmt.setString(6,sc.getCsType());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}


	public int updateConsulting(Connection conn, StudentConsulting sc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateConsulting");
		

//		updateConsulting=UPDATE CONSULTING SET CS_CONTENTS=?,CS_DATE=?,CS_TIME=?,CS_WAY=?,CS_TYPE=? WHERE S_ID=? AND CS_NO=?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sc.getCsContent());
			pstmt.setDate(2,sc.getCsDate());
			pstmt.setString(3,sc.getCsTime());
			pstmt.setString(4,sc.getCsWay());
			pstmt.setString(5,sc.getCsType());
			pstmt.setString(6,sc.getsId());
			pstmt.setInt(7,sc.getCsNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}


	public int deleteConsulting(Connection conn, int csNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteConsulting");
		

//		updateConsulting=UPDATE CONSULTING SET CS_CONTENTS=?,CS_DATE=?,CS_TIME=?,CS_WAY=?,CS_TYPE=? WHERE S_ID=? AND CS_NO=?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,csNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}



	public int getListCount(Connection conn, String sId) {
		int listCount = 0;

		PreparedStatement pstmt=null;
		ResultSet rset = null;

		String sql = prop.getProperty("getConsultingListCount");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sId);
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
	public ArrayList<Professors> professorsList(Connection conn, PageInfoprof pi) {
		ArrayList<Professors> list = new ArrayList<Professors>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("professorsList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Professors p = new Professors();
				p.setcName(rset.getString("C_NAME"));
				p.setpEmail(rset.getString("P_EMAIL"));
				p.setUserId(rset.getString("P_ID")	);
				p.setUserName(rset.getString("P_NAME"));
				p.setpPhone(rset.getString("P_PHONE"));
				list.add(p);
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
	
	public Professors searchProfessors(Connection conn, String search) {
		Professors prof = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchProfessors");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				prof=new Professors();
				prof.setcName(rset.getString("C_NAME"));
				prof.setpEmail(rset.getString("P_EMAIL"));
				prof.setUserId(rset.getString("P_ID")	);
				prof.setUserName(rset.getString("P_NAME"));
				prof.setpPhone(rset.getString("P_PHONE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return prof;
	}
	
	public ArrayList<Professors> getPList(Connection conn) {
		ArrayList<Professors> pList = new ArrayList<Professors>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("getPList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				pList.add(new Professors(
						rset.getString("P_ID")
						,rset.getString("P_PWD")
						,rset.getString("P_NAME")
						,rset.getString("C_NO")
						,rset.getString("P_PHONE")
						,rset.getString("P_EMAIL")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return pList;
	}

	public int insertProfessors(Connection conn, Professors prof) {
		int result=0;
		PreparedStatement pstmt= null;
		String sql = prop.getProperty("insertProfessors");
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, prof.getUserId());
			pstmt.setString(2, prof.getUserPwd());
			pstmt.setString(3, prof.getUserName());
			pstmt.setString(4, prof.getcNo());
			pstmt.setString(5, prof.getpPhone());
			pstmt.setString(6, prof.getpEmail());

			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateProfessors(Connection conn, Professors prof) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateProfessors");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, prof.getpEmail());
			pstmt.setString(2, prof.getpPhone());
			pstmt.setString(3, prof.getUserId());
			
			result = pstmt.executeUpdate();
			System.out.println(prof.getpPhone());
			System.out.println(prof.getpEmail());
			System.out.println(prof.getUserId());
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int pIdCheck(Connection conn, String pId) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("pIdCheck");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, pId);
			
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
	
	public int getListCount(Connection conn) {
		int listCount = 0;

		Statement stmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("getListCount");
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



	public ArrayList<Category> selectCategoryList(Connection conn) {
		ArrayList<Category> cateList = new ArrayList<Category>();
		Statement stmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("selectCateogryList");
		
		
		try {
			stmt = conn.createStatement();
			rset=stmt.executeQuery(sql);
			
			while(rset.next()) {
				Category cate = new Category();
				cate.setCategoryName(rset.getString("C_NAME"));
				cate.setCategoryNo(rset.getString("C_NO"));
				cateList.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rset);
			close(stmt);
		}
		return cateList;
	}
	public int deleteProfessors(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteProfessors");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}


	public int getAutoCreateId(Connection conn, String categoryNo) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		int lastNo=01;
		String sql=prop.getProperty("getAutoCreateId");
//		SELECT SUBSTR(A.P_ID,5) FROM(SELECT * FROM PROFESSORS WHERE C_NO=? ORDER BY P_ID DESC) A WHERE ROWNUM=1
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, categoryNo);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				lastNo=rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
				
		return lastNo;
	}


	

}
