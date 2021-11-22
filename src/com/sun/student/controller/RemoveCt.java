package com.sun.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.student.model.service.StudentService;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class RemoveCt
 */
@WebServlet("/remove.ct")
public class RemoveCt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = ((User)request.getSession().getAttribute("loginUser")).getUserId();
		String no = (String) request.getParameter("cfNo");
		int cfNo = 0;
		int result=0;
		if(no!=null) {
			cfNo = Integer.parseInt(no);
			result = new StudentService().deleteCertificate(sId,cfNo);

		}
		System.out.println("no  : " + no + ", cfNo : " + cfNo);
		

 		if(result>0) {
 			HttpSession session= request.getSession();
 			session.setAttribute("msg", "자격증 삭제를 완료했습니다.");
 			response.sendRedirect("ct.st");
 		}else {
 			request.setAttribute("msg", "자격증 삭제를 실패했습니다.");
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
