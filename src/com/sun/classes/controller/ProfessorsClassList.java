package com.sun.classes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.classes.model.service.ClassService;
import com.sun.classes.model.vo.Classes;
import com.sun.student.model.vo.PageInfo;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class ProfessorsClassList
 */
@WebServlet("/classList.pr")
public class ProfessorsClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorsClassList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("loginUser");
		String cName= request.getParameter("cName");
		System.out.println("이전!!"+cName);
		
		int listCount;
		int currentPage;	
		int startPage;		
		int endPage;		
		int maxPage;	
		int pageLimit;		
		int listLimit;	
		
		listCount = new ClassService().getListCount(user.getUserId());
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		pageLimit = 5;
		listLimit = 10;
		maxPage = (int)Math.ceil((double)listCount/listLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;
		

		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		if(cName==null) {
			cName="%";
		}
		else {
			cName=cName+"%";
		}
		System.out.println("이후!!"+cName);
		PageInfo pi = new PageInfo(listCount, currentPage, startPage, endPage, maxPage, pageLimit, listLimit);
		
		ArrayList<Classes> list = new ClassService().selectClassList(user.getUserId(),cName,pi);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/professors/class/professorsClassListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
