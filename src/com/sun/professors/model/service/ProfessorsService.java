package com.sun.professors.model.service;

import static com.sun.common.JDBCTemplate.close;
import static com.sun.common.JDBCTemplate.commit;
import static com.sun.common.JDBCTemplate.getConnection;
import static com.sun.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.sun.professors.model.dao.ProfessorsDao;
import com.sun.professors.model.vo.Category;
import com.sun.professors.model.vo.PageInfoprof;
import com.sun.professors.model.vo.Professors;
import com.sun.student.model.dao.StudentDao;
import com.sun.student.model.vo.PageInfo;

import com.sun.student.model.vo.Student;
import com.sun.student.model.vo.StudentConsulting;

public class ProfessorsService {

	public ArrayList<Student> selectStduentList(String userId) {
		Connection conn = getConnection();
		ArrayList<Student> sList = new ProfessorsDao().selectchList(conn,userId);
		close(conn);
		return sList;
	}

	public ArrayList<StudentConsulting> selectConsultingList(String sId,PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<StudentConsulting> cList = new ProfessorsDao().selectConsultingList(conn,sId,pi);
		return cList;
	}

	public int insertConsulting(StudentConsulting sc) {
		int result=0;
		Connection conn = getConnection();

		result=new ProfessorsDao().insertConsulting(conn,sc);

		
		if(result>0) {
			commit(conn);
			
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateConsulting(StudentConsulting sc) {
		int result=0;
		Connection conn = getConnection();

		result=new ProfessorsDao().updateConsulting(conn,sc);

		
		if(result>0) {
			commit(conn);
			
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteConsulting(int csNo) {
		int result=0;
		Connection conn = getConnection();

		result=new ProfessorsDao().deleteConsulting(conn,csNo);

		
		if(result>0) {
			commit(conn);
			
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int getListCount(String sId) {
		Connection conn = getConnection();
		int listCount = new ProfessorsDao().getListCount(conn,sId);
		
		close(conn);
		return listCount;
	}
	
	
	
	//합친부분
	public ArrayList<Professors> professorsList(PageInfoprof pi) {
		Connection conn = getConnection();

		ArrayList<Professors> list = new ProfessorsDao().professorsList(conn,pi);
		
		close(conn);
		
		return list;
	}


	public Professors searchProfessors(String search) {
		Connection conn = getConnection();

		Professors prof = new ProfessorsDao().searchProfessors(conn,search);
		
		close(conn);
		
		return prof;
	}

	public ArrayList<Professors> getPList() {
		Connection conn = getConnection();

		ArrayList<Professors> pList = new ProfessorsDao().getPList(conn);
		
		close(conn);
		
		return pList;
	}

	public int insertProfessors(Professors prof) {
		Connection conn = getConnection();
		
		int result = new ProfessorsDao().insertProfessors(conn, prof);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Professors professorsDetail(String userId) {
		Connection conn = getConnection();

		Professors prof = new ProfessorsDao().searchProfessors(conn,userId);
		
		close(conn);
		
		return prof;
	}

	public int updateProfessors(Professors prof) {
		Connection conn = getConnection();
		
		int result = new ProfessorsDao().updateProfessors(conn,prof);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public int pIdCheck(String pId) {
		Connection conn = getConnection();
		
		int result = new ProfessorsDao().pIdCheck(conn,pId);
		
		close(conn);
		
		return result;
	}
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new ProfessorsDao().getListCount(conn);
		
		close(conn);
		return listCount;
	}


	public ArrayList<Category> selectCategoryList() {
		Connection conn = getConnection();

		ArrayList<Category> cateList = new ProfessorsDao().selectCategoryList(conn);
		
		close(conn);
		
		return cateList ;
		
	}
	public int deleteProfessors(String userId) {
		Connection conn = getConnection();
		
		int result = new ProfessorsDao().deleteProfessors(conn, userId);
		
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;

	}

	public String getAutoCreateId(String categoryNo) {
		Connection conn = getConnection();
		String finalUserId="";
		int userId = 01;
		userId=new ProfessorsDao().getAutoCreateId(conn,categoryNo);
		System.out.println("subString!!!"+categoryNo);
		String temp="P"+categoryNo.substring(1,4);
		finalUserId=temp+String.format("%02d",userId+1);

		close(conn);
		
		return finalUserId ;
	}

}
