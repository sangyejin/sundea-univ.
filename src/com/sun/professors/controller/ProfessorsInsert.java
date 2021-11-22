package com.sun.professors.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.professors.model.service.ProfessorsService;
import com.sun.professors.model.vo.Professors;
import com.sun.student.model.vo.Student;


/**
 * Servlet implementation class ProfessorsInsert
 */
@WebServlet("/insert.prof")
public class ProfessorsInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorsInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId= request.getParameter("userId");
		String userPwd= request.getParameter("userPwd");
		String userName= request.getParameter("userName");
		String categoryNo= request.getParameter("categoryNo");
		String pPhone= request.getParameter("pPhone");
		String pEmail= request.getParameter("pEmail");
		System.out.println(userId);
		
		Professors prof = new Professors();
		prof.setUserId(userId);
		prof.setUserPwd(userPwd);
		prof.setUserName(userName);
		prof.setcNo(categoryNo);
		prof.setpPhone(pPhone);
		prof.setpEmail(pEmail);
		
		System.out.println("category!!!!"+categoryNo);
		int result = new ProfessorsService().insertProfessors(prof);
		
		if(result>0) {
			request.getSession().setAttribute("msg", "교수 등록 성공");
			response.sendRedirect(request.getContextPath()+"/list.prof");
		}
		else {
			request.setAttribute("msg", "교수 등록 실패");
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
