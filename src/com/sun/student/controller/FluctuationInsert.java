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
 * Servlet implementation class FluctuationInsert
 */
@WebServlet("/insert.fl")
public class FluctuationInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FluctuationInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sId= request.getParameter("sId");
		String no= request.getParameter("flNo");
		String flChange= request.getParameter("flChange");
		String flReason= request.getParameter("flReason");
		String year= request.getParameter("flYear");
		String semester=request.getParameter("flSemester");
		
		int flNo = 0;
		int flYear = 0;
		int flSemester = 0;
		
		if(no!=null && year!=null && semester!=null) {
			flNo = Integer.parseInt(no);
			flYear= Integer.parseInt(year);
			flSemester= Integer.parseInt(semester);
		}
		
		Fluctuation fl = new Fluctuation();
		fl.setsId(sId);
		fl.setFlNo(flNo);
		fl.setFlChange(flChange);
		fl.setFlReason(flReason);
		fl.setFlYear(flYear);
		fl.setFlSemester(flSemester);
		
		int result = new StudentService().insertFluctuation(fl);
		
		if(result>0) {
			request.getSession().setAttribute("msg", "학적 등록 성공");
			response.sendRedirect("list.st");
		}
		else {
			request.setAttribute("msg", "학적 등록 실패");
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
