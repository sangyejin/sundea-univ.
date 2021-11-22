package com.sun.classes.model.service;

import static com.sun.common.JDBCTemplate.close;
import static com.sun.common.JDBCTemplate.commit;
import static com.sun.common.JDBCTemplate.getConnection;
import static com.sun.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;

import com.sun.classes.model.dao.ClassDao;
import com.sun.classes.model.vo.Classes;
import com.sun.classes.model.vo.PageInfoclass;
import com.sun.student.model.dao.StudentDao;
import com.sun.student.model.vo.PageInfo;

public class ClassService {
	
	public ArrayList<Classes> selectClassList(String userId,String cName,PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Classes> list = new ClassDao().selectClassList(conn,userId,cName,pi);
		close(conn);
		return list;

	}

//	연도와학기
	public ArrayList<Classes> selectClassByUserIdAndYearAndSemester(String userId) {
		Connection conn = getConnection();
		
		Calendar calendar = Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;
		int semester=0; //0학기는 계절학기로 취급
		if(month>=2 && month<=6) { //1학기
			semester=1;
		}
		else if(month>=9 && month<=12) { //2학기
			semester=2;
		}
		
		ArrayList<Classes> list = new ClassDao().selectClassByYearAndSemester(conn,userId,year,semester);
		close(conn);
		return list;
	}


		public int getListCount(String userId) {
			Connection conn = getConnection();
			int listCount = new ClassDao().getListCount(conn,userId);
			
			close(conn);
			return listCount;
		}

		
		//합친부분
		public ArrayList<Classes> selectClass(String userId) {
			Connection conn = getConnection();
			ArrayList<Classes> list = new ClassDao().selectClass(conn,userId);
			close(conn);
			return list;

		}

		public int getListAdmin() {
			Connection conn = getConnection();
			int listCount = new ClassDao().getListAdmin(conn);
			
			close(conn);
			return listCount;
		}

		

		public ArrayList<Classes> classList(PageInfoclass pi) {
			Connection conn = getConnection();

			ArrayList<Classes> list = new ClassDao().classList(conn,pi);
			
			close(conn);
			
			return list;
		}

		
		public Classes ClassesDetail(String classNo) {
			Connection conn = getConnection();

			Classes classes = new ClassDao().searchClasses(conn,classNo);
			
			close(conn);
			
			return classes;
		}

		
		public Classes searchClasses(String search) {
			Connection conn = getConnection();

			Classes classes = new ClassDao().searchClasses(conn,search);
			
			close(conn);
			
			return classes;
		}

		public int insertClasses(Classes classes) {
			Connection conn = getConnection();
			
			int result = new ClassDao().insertClasses(conn, classes);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}

		public int classNoCheck(String classNo) {
			Connection conn = getConnection();
			
			int result = new ClassDao().classNoCheck(conn,classNo);
			
			close(conn);
			
			return result;
		}

		public int updateStudent(String changeNO, String changeName) {
			
			Connection conn = getConnection();
			
			int result = new ClassDao().updateStudent(conn,changeNO,changeName);

			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			return result;
		}

		public int deleteClasses(String classNo) {
			Connection conn = getConnection();
			
			int result = new ClassDao().deleteClasses(conn, classNo);
			
			if(result>0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
			close(conn);
			return result;
		}


		public int pIdCheck(String pId) {
			Connection conn = getConnection();
			
			int result = new ClassDao().pIdCheck(conn,pId);
			
			close(conn);
			
			return result;
		}


}
