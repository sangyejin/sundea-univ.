package com.sun.professors.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.professors.model.service.ProfessorsService;
import com.sun.professors.model.vo.Professors;
;

/**
 * Servlet implementation class ProfessorsUpdate
 */
@WebServlet("/update.prof")
public class ProfessorsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorsUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pId= request.getParameter("pId");
		String email=request.getParameter("email");
		String phone= request.getParameter("phone");
		Professors p = new Professors();
		p.setUserId(pId);
		p.setpPhone(phone);
		p.setpEmail(email);
		int updatest = new ProfessorsService().updateProfessors(p);
		
		PrintWriter out = response.getWriter();
		if(updatest>0) {
			out.print("success");
			
		}else {
			out.print("fail");
			
		}
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
