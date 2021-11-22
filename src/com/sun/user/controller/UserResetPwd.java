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
 * Servlet implementation class UserRestPwd
 */
@WebServlet("/resetPwd.us")
public class UserResetPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserResetPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId= request.getParameter("userId");
		String userName= request.getParameter("userName");
		String userEmail= request.getParameter("userEmail");
		String tableName= request.getParameter("tableName");
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		
		System.out.println(userName+"    "+ userEmail+"  "+ tableName+"  "+userId);
		User resetUser = new UserService().selectUpdateUser(user,tableName);
		if( resetUser!=null) {
			int result = new UserService().updateUserPwd(resetUser,tableName);
			System.out.println(user.getUserId());
			if(result>0) {
				request.setAttribute("flag","Y");
				request.setAttribute("msg","비밀번호가 초기화 되었습니다. 초기화된 비밀번호는 아이디입니다.");
			}
			else {
				request.setAttribute("flag","N");
				request.setAttribute("msg","비밀번호를 초기화하지 못했습니다.");
			}
		}
		
		else {
			request.setAttribute("msg","존재하지 않는 유저입니다.");
			request.setAttribute("flag","N");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("views/user/resetPwdForm.jsp");
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
