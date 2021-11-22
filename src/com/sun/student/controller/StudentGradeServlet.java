package com.sun.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.StudentDivisionGrade;
import com.sun.student.model.vo.StudentEarnCredit;
import com.sun.student.model.vo.StudentSemeterGrade;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class StudentGradeServlet
 */
@WebServlet("/student.grade")
public class StudentGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("loginUser");
		
		ArrayList<StudentDivisionGrade> list = new StudentService().student_divisionGrade(user.getUserId());
		ArrayList<StudentSemeterGrade> SList = new StudentService().student_semesterGrade(user.getUserId());
		ArrayList<StudentEarnCredit> EList = new StudentService().student_earnCredit(user.getUserId());
		ArrayList<StudentSemeterGrade> rank =  new StudentService().student_rank(user.getUserId());
		
		
		request.setAttribute("list", list);
		request.setAttribute("SList", SList);
		request.setAttribute("EList", EList);
		request.setAttribute("rank", rank);
		
		
		request.getRequestDispatcher("views/student/student_grade.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
