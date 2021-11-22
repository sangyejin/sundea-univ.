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
import com.sun.student.model.vo.Fluctuation;


/**
 * Servlet implementation class ProfessorsDetail
 */
@WebServlet("/detail.prof")
public class ProfessorsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorsDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		Professors prof = new ProfessorsService().professorsDetail(userId);
		
		System.out.println(prof.getpEmail());
		
		if(prof != null) {
			request.setAttribute("prof", prof);
			

			request.getRequestDispatcher("views/admin/professors/profDetail.jsp").forward(request, response);
		}else {
			
			request.setAttribute("msg", "게시물 상세 조회를 실패했습니다.");
			RequestDispatcher view= request.getRequestDispatcher("views/common/errorPage.jsp");
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
