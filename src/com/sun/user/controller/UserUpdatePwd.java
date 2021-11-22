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
 * Servlet implementation class UserUpdatePwd
 */
@WebServlet("/updatePwd.us")
public class UserUpdatePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatePwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId= ((User)request.getSession().getAttribute("loginUser")).getUserId();
		String userPwd= request.getParameter("userPwd");
		String newPwd= request.getParameter("newPwd");
		String tableName=null;
		
		if(userId!=null && userId.charAt(0)=='P') {
			tableName="Professors";
		}else {
			tableName="Student";
		}
		
		User user= new UserService().loginUser(userId,userPwd);
		
		if( user!=null) {
			
			int result = new UserService().updateUserNewPwd(user.getUserId(),newPwd, tableName);

			if(result>0) {
				request.setAttribute("flag","Y");
				request.setAttribute("msg","비밀번호가 변경되었습니다.");
			}else {
				request.setAttribute("flag","N");
				request.setAttribute("msg","비밀번호를 변경하지 못했습니다.");
			}
			
		}else {
			request.setAttribute("flag","N");
			request.setAttribute("msg","기존 비밀번호가 일치하지 않습니다.");
		}
		RequestDispatcher view = request.getRequestDispatcher("views/user/updatePwdForm.jsp");
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
