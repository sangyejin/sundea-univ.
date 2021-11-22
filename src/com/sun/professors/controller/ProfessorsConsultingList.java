package com.sun.professors.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.professors.model.dto.ConsultingPageInfoDto;
import com.sun.professors.model.service.ProfessorsService;
import com.sun.student.model.vo.PageInfo;
import com.sun.student.model.vo.StudentConsulting;


@WebServlet("/selectConsultingList.pr")
public class ProfessorsConsultingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProfessorsConsultingList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("sId");
		
		int listCount;			// 총 게시글 갯수
		int currentPage=1;		// 현재 페이지 (즉, 요청한 페이지)
		int startPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 시작 수 
		int endPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 끝 수
		int maxPage;			// 전체 페이지에서의 가장 마지막 페이지
		
		int pageLimit=4;			// 한 페이지 하단에 보여질 페이지 최대 갯수
		int boardLimit=5;			// 한 페이지에 보여질 게시글 최대 갯수
		
		
		listCount = new ProfessorsService().getListCount(sId);
		System.out.println(listCount);
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		maxPage = (int)Math.ceil((double)listCount/boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, startPage, endPage, maxPage, pageLimit, boardLimit);
		ArrayList<StudentConsulting> cList = new ProfessorsService().selectConsultingList(sId,pi);
		
		ConsultingPageInfoDto cpDto= new ConsultingPageInfoDto(pi,cList);
		
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(cpDto, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
