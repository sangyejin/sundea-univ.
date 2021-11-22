package com.sun.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.ClassHistories;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class ForStudentFl
 */
@WebServlet("/stpage.ch")
public class ForStudentCH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForStudentCH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userId=(User)request.getSession().getAttribute("loginUser");
		String year = request.getParameter("classYear"); 
		String semester = request.getParameter("classSemester"); 
		String className = request.getParameter("className");
		String cre = request.getParameter("credit");
		String typeName = request.getParameter("typeName");
		String pName = request.getParameter("pName");

		int classYear =0;
		int classSemester =0; 
		int credit=0;
		
		if(year!=null && semester!=null) {
			classYear=Integer.parseInt(year);
			classSemester = Integer.parseInt(semester);
			credit=Integer.parseInt(cre);
		}
		
		ClassHistories ch = new ClassHistories(classYear,classSemester,className,credit,typeName,pName);

		ArrayList<ClassHistories> list = new StudentService().ClassHistories(userId.getUserId(), ch);


		if(ch != null) {
			request.setAttribute("list", list);

			request.getRequestDispatcher("views/student/CHforST.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "수강 내역 상세 조회를 실패했습니다.");
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
