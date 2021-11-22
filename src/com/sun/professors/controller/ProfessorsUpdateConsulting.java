package com.sun.professors.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.professors.model.service.ProfessorsService;
import com.sun.student.model.vo.StudentConsulting;


@WebServlet("/updateConsulting.pr")
public class ProfessorsUpdateConsulting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProfessorsUpdateConsulting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sId = request.getParameter("sId");
		String type = request.getParameter("type");
		String content = request.getParameter("content");
		String time = request.getParameter("time");
		String d=request.getParameter("date");
		String way = request.getParameter("way");
		String scNo = request.getParameter("csNo");
		System.out.println("업데이트!!"+scNo);
		java.sql.Date date=java.sql.Date.valueOf(d); //sql date로 형변환
		
		
		StudentConsulting sc = new StudentConsulting();
		sc.setCsContent(content);
		sc.setCsDate(date);
		sc.setCsNo(Integer.parseInt( scNo));
		sc.setCsTime(time);
		sc.setCsType(type);
		sc.setCsWay(way);
		sc.setsId(sId);
		
		int result = new ProfessorsService().updateConsulting(sc);
		

		PrintWriter out = response.getWriter();
		if(result>0) {
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
