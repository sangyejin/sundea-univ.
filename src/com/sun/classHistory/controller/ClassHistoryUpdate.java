package com.sun.classHistory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.classHistory.model.service.ClassHistoryService;
import com.sun.classHistory.model.vo.ClassHistory;

/**
 * Servlet implementation class ClassHistoryUpdate
 */
@WebServlet("/updatechList.pr")
public class ClassHistoryUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassHistoryUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] temp1 = null;
		ArrayList<ClassHistory> chList=new ArrayList<ClassHistory>();
		temp1=request.getParameterValues("chList[]");
		String classNo=request.getParameter("classNo");
		System.out.println("temp11"+temp1);
		if(temp1!=null) {
			for(int i=0; i<temp1.length;i++) {
				System.out.println(temp1[i]);
				String[] temp2 = temp1[i].split(",");
				
				ClassHistory ch= new ClassHistory(temp2[0],Float.parseFloat( temp2[1]));
				chList.add(ch);
			}
		}
		
		int result = new ClassHistoryService().updateCh(chList,classNo);
		PrintWriter out = response.getWriter();
		if(result>0) {
			System.out.println("success!!!!");
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
