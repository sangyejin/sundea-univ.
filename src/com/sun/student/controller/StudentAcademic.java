package com.sun.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.Student;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class StudentAcademic
 */
@WebServlet("/StudentAcademic")
public class StudentAcademic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAcademic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("loginUser");
		Student st = new StudentService().selectStudent(user.getUserId());
		Student stp = new StudentService().studentPersonalselect(user.getUserId());
		if(st ==null || stp==null) {
			request.getSession().setAttribute("msg", "조회할 신상 정보가 존재하지 않습니다. 신상 등록 페이지로 넘어갑니다.");
			request.getRequestDispatcher("views/admin/student/aintGotInfo.jsp").forward(request, response);

		}else {

			request.setAttribute("stp", stp);
			request.setAttribute("st", st);
			request.getRequestDispatcher("views/admin/student/stmenu.jsp").forward(request, response);
		
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
