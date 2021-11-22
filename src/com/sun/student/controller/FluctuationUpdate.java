package com.sun.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.Fluctuation;

/**
 * Servlet implementation class FluctuationUpdate
 */
@WebServlet("/update.fl")
public class FluctuationUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FluctuationUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 
		String flChange= request.getParameter("flChange");
		String flReason= request.getParameter("flReason");
		String userId=request.getParameter("getsId");
		String no=request.getParameter("flNo");
		int flNo=0;
		if(no!=null) {
			flNo=Integer.parseInt(no);
		}
		Fluctuation fl = new Fluctuation();
		fl.setFlChange(flChange);
		fl.setFlReason(flReason);
		fl.setsId(userId);
		fl.setFlNo(flNo);

		int updatefl = new StudentService().updateFluctutation(fl);
		
		if(updatefl > 0) {
			request.getSession().setAttribute("msg", "학적 수정을 성공했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/admin/student/stDetail.jsp");
			response.sendRedirect("list.st");
		}else {
			request.setAttribute("msg", "학적 수정을 실패했습니다.");
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
