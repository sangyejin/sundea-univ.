package com.sun.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.user.model.service.UserService;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class UserFindId
 */
@WebServlet("/findId.us")
public class UserFindId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFindId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userName= request.getParameter("userName");
		String userEmail= request.getParameter("userEmail");
		String tableName= request.getParameter("tableName");
		System.out.println(userName+"    "+ userEmail+"  "+ tableName);
		User user= new UserService().selectFindUser(userName,userEmail,tableName);
		
		
		RequestDispatcher view = request.getRequestDispatcher("views/user/findIdForm.jsp");
		
		if( user!=null) {
			System.out.println(user.getUserId());
			request.setAttribute("userId",user.getUserId());
			request.setAttribute("flag","Y");
		}else {
			request.setAttribute("userId",null);
			request.setAttribute("msg", "존재하지 않는 유저입니다. 다시 시도해주십시오.");
			request.setAttribute("flag","N");
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
