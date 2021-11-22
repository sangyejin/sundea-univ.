package com.sun.student.model.service;


import static com.sun.common.JDBCTemplate.close;
import static com.sun.common.JDBCTemplate.commit;
import static com.sun.common.JDBCTemplate.getConnection;
import static com.sun.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.sun.professors.model.dao.ProfessorsDao;
import com.sun.student.model.dao.StudentDao;
import com.sun.student.model.vo.Attachment;
import com.sun.student.model.vo.Certificate;
import com.sun.student.model.vo.ClassHistories;
import com.sun.student.model.vo.DropDown;
import com.sun.student.model.vo.Fluctuation;
import com.sun.student.model.vo.PageInfo;
import com.sun.student.model.vo.Student;
import com.sun.student.model.vo.StudentConsulting;
import com.sun.student.model.vo.StudentDivisionGrade;
import com.sun.student.model.vo.StudentEarnCredit;
import com.sun.student.model.vo.StudentSemeterGrade;

public class StudentService {
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new StudentDao().getListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList<Student> studentList(PageInfo pi){
		Connection conn = getConnection();

		ArrayList<Student> list = new StudentDao().studentList(conn,pi);
		
		close(conn);
		
		return list;
	}

	public int insertStudent(Student st) {
		
		Connection conn = getConnection();
		
		int result = new StudentDao().insertStudent(conn, st);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	public ArrayList<DropDown> getDList() {
		Connection conn = getConnection();

		ArrayList<DropDown> dList = new StudentDao().getDList(conn);
		
		close(conn);
		
		return dList;
	}

	public ArrayList<Student> getCList() {
		Connection conn = getConnection();

		ArrayList<Student> cList = new StudentDao().getCList(conn);
		
		close(conn);
		
		return cList;
	}

	public Student searchStudent(String search) {
		Connection conn = getConnection();

		Student st = new StudentDao().searchStudent(conn,search);
		
		close(conn);
		
		return st;
	}

	public Student studentDetail(String userId) {
		Connection conn = getConnection();

		Student st = new StudentDao().searchStudent(conn,userId);
		
		close(conn);
		
		return st;
	}

	public ArrayList<Fluctuation> fluctuationDetail(String userId) {
		Connection conn = getConnection();

		ArrayList<Fluctuation> fl = new StudentDao().fluctuationDetail(conn,userId);
		
		close(conn);
		
		return fl;
	}
	
	public int updateFluctutation(Fluctuation fl) {
		Connection conn = getConnection();
		
		int result = new StudentDao().updateFluctutation(conn,fl);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}  
		
		return result;
	}

	public ArrayList<StudentConsulting> student_consultingList(String userId) {
		Connection conn = getConnection();

		ArrayList<StudentConsulting> list = new StudentDao().student_consultingList(conn,userId);
		
		close(conn);
		
		return list;
	}

	public String searchAdvisor(String userId) {
		Connection conn = getConnection();
		
		String advisor = new StudentDao().searchAdvisor(conn, userId);
		close(conn);
		return advisor;
	}

	public ArrayList<StudentDivisionGrade> student_divisionGrade(String userId) {
		Connection conn = getConnection();
		
		ArrayList<StudentDivisionGrade> list = new StudentDao().student_divisionGrade(conn, userId);
		close(conn);
		return list;
	}

	public ArrayList<StudentSemeterGrade> student_semesterGrade(String userId) {
		Connection conn = getConnection();
		
		ArrayList<StudentSemeterGrade> SList = new StudentDao().student_semesterGrade(conn, userId);
		close(conn);
		return SList;
	}

	public int idCheck(String userId) {
		Connection conn = getConnection();
		
		int result = new StudentDao().idCheck(conn,userId);
		
		close(conn);
		
		return result;
	}

	public int updateStudent(Student st) {
		Connection conn = getConnection();
		
		int result = new StudentDao().updateStudent(conn,st);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public int pIdCheck(String pId) {
		Connection conn = getConnection();
		
		int result = new StudentDao().pIdCheck(conn,pId);
		
		close(conn);
		
		return result;
	}

	public int insertFluctuation(Fluctuation fl) {
		Connection conn = getConnection();
		
		int result = new StudentDao().insertFluctuation(conn, fl);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

  public int deleteStudent(String userId) {
		Connection conn = getConnection();
		
		int result = new StudentDao().deleteStudent(conn, userId);
		
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Student> searchName(String name) {
		
		Connection conn = getConnection();

		ArrayList<Student> list = new StudentDao().searchName(conn,name);
		
		close(conn);
		
		return list;
	}

  
  
	public ArrayList<Certificate> CertificateList(String userId) {
		Connection conn = getConnection();
		
		ArrayList<Certificate> list = new StudentDao().CertificateList(conn, userId);
		
		close(conn);
		
		return list;
	}

	public int addCertificate(Certificate ct /*, Attachment at*/) {
		Connection conn = getConnection();
	
		int result1 = new StudentDao().addCertificate(conn,ct);
		/*
		int result2 = 1;
		
		if(at != null) {
			result2 = new StudentDao().addAttachment(conn,at);
		}
		*/
		if(result1/** result2*/ >0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result1/** result2*/;
	}	
  
	public ArrayList<StudentEarnCredit> student_earnCredit(String userId) {
		Connection conn = getConnection();
		
		ArrayList<StudentEarnCredit> SList = new StudentDao().student_earnCredit(conn, userId);
		close(conn);
		return SList;
	}

	public ArrayList<StudentSemeterGrade> student_rank(String userId) {
		Connection conn = getConnection();
		
		ArrayList<StudentSemeterGrade> rank = new StudentDao().student_rank(conn, userId);
		close(conn);
		return rank;
	}

	public int deleteCertificate(String sId, int cfNo) {
		Connection conn = getConnection();
		
		int result = new StudentDao().deleteCertificate(conn, sId, cfNo);
		
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Student selectStudent(String userId) {
		
		Connection conn = getConnection();

		Student st = new StudentDao().selectStudent(conn,userId);
	
		close(conn);
    
		return st;
  }

	public int stPersonalInsert(String userId, Student stp) {
		int result=0;
		Connection conn = getConnection();

		result=new StudentDao().stPersonalInsert(conn,stp,userId);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public Student studentPersonalselect(String userId) {
		Connection conn = getConnection();

		Student per = new StudentDao().studentPersonalselect(conn,userId);
	
		close(conn);
    
		return per;
	}
	public ArrayList<ClassHistories> ClassHistories(String userId, ClassHistories ch) {
		Connection conn = getConnection();

		ArrayList<ClassHistories> list = new StudentDao().ClassHistories(conn,userId,ch);
	
		close(conn);
    
		return list;
  }

	public int aintInsert(String userId, Student stp) {
		int result=0;
		Connection conn = getConnection();

		result=new StudentDao().aintInsert(conn,stp,userId);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}


}
