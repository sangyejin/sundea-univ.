package com.sun.professors.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.professors.model.service.ProfessorsService;
import com.sun.student.model.vo.Student;
import com.sun.student.model.vo.StudentConsulting;
import com.sun.user.model.vo.User;


@WebServlet("/consultingList.pr")
public class ProfessorsSelectStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfessorsSelectStudent(){
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= (User)request.getSession().getAttribute("loginUser");
		
		ArrayList<Student> sList = new ProfessorsService().selectStduentList(user.getUserId());
		request.setAttribute("sList", sList);
		request.getRequestDispatcher("views/professors/consulting/professorsConsultingView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
