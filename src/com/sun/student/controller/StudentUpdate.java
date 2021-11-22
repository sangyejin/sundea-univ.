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
import com.sun.student.model.vo.DropDown;
import com.sun.student.model.vo.Student;

/**
 * Servlet implementation class StudentUpdate
 */
@WebServlet("/update.st")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 
		String userId= request.getParameter("userId");
		String pId= request.getParameter("pId");
		
		Student st = new Student();
		st.setUserId(userId);
		st.setPId(pId);
		
		int updatest = new StudentService().updateStudent(st);
		
		if(updatest > 0) {
			request.getSession().setAttribute("msg", "학생 정보 수정을 성공했습니다.");
			response.sendRedirect("list.st");
			
		}else {
			request.setAttribute("msg", "학생 정보 수정을 실패했습니다.");
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
