package com.sun.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.Student;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class StudentPersonalInsertServlet
 */
@WebServlet("/aint.info")
public class aintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		User user=(User)request.getSession().getAttribute("loginUser");
		
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String military = request.getParameter("military");
		String address = request.getParameter("address");
		String account = request.getParameter("account");
		String bank = request.getParameter("bank");
		String holder = request.getParameter("holder");
		
		Student stp = new Student();
		stp.setsPhone(phone);
		stp.setsEmail(email);
		stp.setMilitary(military);
		stp.setAddress(address);
		stp.setAccount(account);
		stp.setBank(bank);
		stp.setHolder(holder);

		int result = new StudentService().aintInsert(user.getUserId(), stp);
		
		if(result>0) {
			request.getSession().setAttribute("msg", "신상 정보 등록 성공");
			response.sendRedirect("StudentAcademic");
		}
		else {
			request.setAttribute("msg", "신상 정보 등록 실패");
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
