package com.sun.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.classes.model.service.ClassService;
import com.sun.classes.model.vo.Classes;
import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.StudentConsulting;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class StudentConsultingList
 */
@WebServlet("/student.consult")
public class StudentConsultingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentConsultingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("loginUser");
		
		ArrayList<StudentConsulting> list = new StudentService().student_consultingList(user.getUserId());
		String advisor = new StudentService().searchAdvisor(user.getUserId());
		request.setAttribute("advisor", advisor);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/student/student_consulting.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
