package com.sun.classes.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.classes.model.service.ClassService;
import com.sun.classes.model.vo.Classes;


/**
 * Servlet implementation class ClassInsert
 */
@WebServlet("/insert.class")
public class ClassInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cId= request.getParameter("cId");
		String cName= request.getParameter("cName");
		String cPlace= request.getParameter("cPlace");
		String type= request.getParameter("ctype");
		String pId= request.getParameter("pId");
		String eYear= request.getParameter("eYear");
		String eSem= request.getParameter("eSemester");
		String cre= request.getParameter("credit");
		
		int classYear = 0;
		int credit = 0;
		int ctype=0;
		int semester = 0;
		
		if(eYear != null && cre != null && type !=null) {
			classYear = Integer.parseInt(eYear);
			credit = Integer.parseInt(cre);
			ctype = Integer.parseInt(type);
			semester = Integer.parseInt(eSem);
		}
		
		Classes classes = new Classes();
		
		classes.setClassNo(cId);
		classes.setClassName(cName);
		classes.setClassPlace(cPlace);
		classes.setClassTypeNo(ctype);
		classes.setpId(pId);
		classes.setClassYear(classYear);
		classes.setClassSemester(semester);
		classes.setCredit(credit);
		
		int result = new ClassService().insertClasses(classes);
		
		if(result>0) {
			request.getSession().setAttribute("msg", "강의 등록 성공");
			response.sendRedirect("list.class");
		}
		else {
			request.setAttribute("msg", "강의 등록 실패");
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
