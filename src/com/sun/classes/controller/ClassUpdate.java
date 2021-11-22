package com.sun.classes.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.classes.model.service.ClassService;
import com.sun.classes.model.vo.Classes;

/**
 * Servlet implementation class StudentUpdate
 */
@WebServlet("/update.class")
public class ClassUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 
		String changeNO= request.getParameter("changeNO");
		String changeName= request.getParameter("changeName");
		
		/*
		Classes cl = new Classes();
		cl.setClassNo(changeNO);
		cl.setClassName(changeName);
		*/
		int updatest = new ClassService().updateStudent(changeNO,changeName);
		
		if(updatest > 0) {
			request.getSession().setAttribute("msg", "강의 정보 수정을 성공했습니다.");
			response.sendRedirect("list.class");
			
		}else {
			request.setAttribute("msg", "강의 정보 수정을 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
