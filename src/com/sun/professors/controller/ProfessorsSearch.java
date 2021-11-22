package com.sun.professors.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.professors.model.service.ProfessorsService;
import com.sun.professors.model.vo.Professors;
import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.Student;

/**
 * Servlet implementation class ProfessorsSearch
 */
@WebServlet("/search.prof")
public class ProfessorsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorsSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search= request.getParameter("search");
		
		Professors prof = new ProfessorsService().searchProfessors(search);
		request.setAttribute("prof", prof);
		
		request.getRequestDispatcher("views/admin/professors/profSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
