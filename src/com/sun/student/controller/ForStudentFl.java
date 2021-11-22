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
import com.sun.student.model.vo.Fluctuation;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class ForStudentFl
 */
@WebServlet("/stpage.fl")
public class ForStudentFl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForStudentFl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userId=(User)request.getSession().getAttribute("loginUser");
		String flChange = request.getParameter("flChange"); 
		String flReason = request.getParameter("flReason"); 
		String flYear = request.getParameter("flYear");
		String flSemester = request.getParameter("flSemester");
		
		
		int year=0;
		int semester=0; 		
		if(flYear!=null && flSemester!=null) {
			year=Integer.parseInt(flYear);
			semester = Integer.parseInt(flSemester);
		}
		//Student st = new StudentService().studentDetail(userId);
		
		Fluctuation fuck = new Fluctuation();
		fuck.setUserId(userId.getUserId());
		fuck.setFlChange(flChange);
		fuck.setFlReason(flReason);
		fuck.setFlYear(year);
		fuck.setFlSemester(semester);

		ArrayList<Fluctuation> fl = new StudentService().fluctuationDetail(userId.getUserId());
		
		if(fl != null) {
			//request.setAttribute("st", st);
			request.setAttribute("fl", fl);

			request.getRequestDispatcher("views/student/FLforST.jsp").forward(request, response);
		}else {
			
			request.setAttribute("msg", "학적 상세 조회를 실패했습니다.");
			RequestDispatcher view= request.getRequestDispatcher("views/common/errorPage.jsp");
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
