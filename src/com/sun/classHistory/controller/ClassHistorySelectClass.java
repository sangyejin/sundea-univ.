package com.sun.classHistory.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sun.classes.model.service.ClassService;
import com.sun.classes.model.vo.Classes;
import com.sun.user.model.vo.User;


@WebServlet("/gradeList.pr")
public class ClassHistorySelectClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassHistorySelectClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= (User)request.getSession().getAttribute("loginUser");
		ArrayList<Classes> classList = new ClassService().selectClassByUserIdAndYearAndSemester(user.getUserId());
		request.setAttribute("classList", classList);
		request.getRequestDispatcher("views/professors/class/professorsGradeView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
