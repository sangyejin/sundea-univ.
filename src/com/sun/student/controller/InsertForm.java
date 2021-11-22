package com.sun.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.professors.model.vo.Professors;
import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.Student;

/**
 * Servlet implementation class InsertForm
 */
@WebServlet("/form.st")
public class InsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ArrayList<Student> pList = new StudentService().getPList();
		ArrayList<Student> cList = new StudentService().getCList();
		//request.setAttribute("pList", pList);
		request.setAttribute("cList", cList);
		
		request.getRequestDispatcher("views/admin/student/stInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
