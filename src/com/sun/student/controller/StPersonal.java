package com.sun.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.Student;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class StPersonal
 */
@WebServlet("/StPersonal")
public class StPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StPersonal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("loginUser");
		Student st = new StudentService().selectStudent(user.getUserId());
		request.setAttribute("st", st);
		request.getRequestDispatcher("views/admin/student/stPersonal.jsp").forward(request, response);
	
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
