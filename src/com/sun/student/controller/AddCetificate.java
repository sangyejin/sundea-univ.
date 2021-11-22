package com.sun.student.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.student.model.service.StudentService;
import com.sun.student.model.vo.Certificate;
import com.sun.user.model.vo.User;

/**
 * Servlet implementation class AddCetificate
 */
@WebServlet("/add.ct")
public class AddCetificate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCetificate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*// 파일 업로드를 위한 라이브러리 : cos.jar (http://www.servlets.com/cos/)

				if (ServletFileUpload.isMultipartContent(request)) {
					// enctype이 multipart/form-data로 잘 전송된 경우 (true)

					// 1. 전송된 파일들을 처리할 작업 내용 (전송되는 파일의 용량 제한, 전달된 파일을 저장할 폴더 경로)

					// 1_1. 전송파일 용량 제한 (int maxSize)
//							: 10Mbyte로 제한  ([참고] cos.jar로 파일 업로드 시 최대 2기가(1.6)까지만 가능)
//					     	1Kbyte = 1024byte (킬로바이트)
//							1Mbyte = 1024Kbyte = 1024 * 1024 byte (메가바이트)
//							1Gbyte = 1024Mbyte = 1024 * 1024 * 1024 Byte (기가바이트)
//							10Mbyte = 10 * 1024 * 1024 byte 

					int maxSize = 10 * 1024 * 1024;
					String resources = request.getServletContext().getRealPath("/resources");

					String savePath = resources + "\\board_upfiles\\";

					System.out.println("savePath : " + savePath);

					// MultipartRequest 객체 생성하기 (즉, 파일서버에 업로드하기)
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
							new MyFileRenamePolicy());
					// new DefaultFileRenamePolicy() 자동으로 이름 재설정해줌
					
					String no = multiRequest.getParameter("cfNo");
					int cfNo=0;
					if(no!=null) {
						cfNo=Integer.parseInt(no);
					}
					
					String user = ((User)request.getSession().getAttribute("loginUser")).getUserId();
					
					user = multiRequest.getParameter(user); //@
					
					String cfName = multiRequest.getParameter("cfName");
					String cfIssue = multiRequest.getParameter("cfIssue");
					
					String date = multiRequest.getParameter("cfDate");
					Date cfDate = null;
					try {
						cfDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						System.out.println("date : " + date + ", cfDate : " + cfDate);
					
					String cfAttachment = multiRequest.getParameter("cfAttachment");
					String cfId = multiRequest.getParameter("cfId");

					Certificate ct = new Certificate();
					ct.setCfNo(cfNo);
					ct.setsId(user); //@
					ct.setCfName(cfName);
					ct.setCfIssue(cfIssue);
					ct.setCfDate(cfDate);
					ct.setCfAttachment(cfAttachment);
					ct.setCfId(cfId);
					

					Attachment at = null;
					if (multiRequest.getOriginalFileName("upfile") != null) { // 파일이 있으면
						String originName = multiRequest.getOriginalFileName("upfile");

						String changeName = multiRequest.getFilesystemName("upfile");

						at = new Attachment();
						at.setFilePath(savePath);
						at.setOriginName(originName);
						at.setChangeName(changeName);

					}

					int result = new StudentService().addCertificate(ct, at);
					
					if (result > 0) {
						request.getSession().setAttribute("msg", "자격증 등록 성공");
						response.sendRedirect("ct.st");
					} else {
						if (at != null) {
							File faileFile = new File(savePath + at.getChangeName());
							faileFile.delete();
						}
						
						request.setAttribute("msg", "자격증 등록 실패");
						RequestDispatcher view= request.getRequestDispatcher("views/common/errorPage.jsp");
						view.forward(request, response);
					}
				}*/
		request.setCharacterEncoding("UTF-8");
		/*
		 * String d=request.getParameter("date");
        java.sql.Date date=java.sql.Date.valueOf(d); //sql date로 형변환
		 */
		int cfNo= Integer.parseInt(request.getParameter("cfNo"));
		String sId = ((User)request.getSession().getAttribute("loginUser")).getUserId();
		String cfName= request.getParameter("cfName");
		String cfIssue= request.getParameter("cfIssue");
		String date= request.getParameter("cfDate");
		java.sql.Date cfDate = java.sql.Date.valueOf(date);
		/*try {
			cfDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			System.out.println("date : " + date + ", cfDate : " + cfDate);
		String cfAttachment=request.getParameter("cfAttachment");
		String cfId=request.getParameter("cfId");
		
		Certificate ct = new Certificate();
		ct.setCfNo(cfNo);
		ct.setsId(sId); //@
		ct.setCfName(cfName);
		ct.setCfIssue(cfIssue);
		ct.setCfDate(cfDate);
		ct.setCfAttachment(cfAttachment);
		ct.setCfId(cfId);
		
		int result = new StudentService().addCertificate(ct);
		
		if(result>0) {
			request.getSession().setAttribute("msg", "자격증 등록 성공");
			response.sendRedirect("ct.st");
		}
		else {
			request.setAttribute("msg", "자격증 등록 실패");
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
