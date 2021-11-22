package com.sun.classes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.classes.model.service.ClassService;
import com.sun.classes.model.vo.Classes;
import com.sun.professors.model.service.ProfessorsService;
import com.sun.professors.model.vo.Professors;

/**
 * Servlet implementation class ClassSearch
 */
@WebServlet("/search.class")
public class ClassSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search= request.getParameter("search");
		
		Classes classes = new ClassService().searchClasses(search);
		request.setAttribute("classes", classes);
		
		request.getRequestDispatcher("views/admin/classes/classSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
