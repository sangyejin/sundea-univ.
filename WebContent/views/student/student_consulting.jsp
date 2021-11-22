<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.sun.student.model.vo.StudentConsulting"%>
<%
	ArrayList<StudentConsulting> list = (ArrayList<StudentConsulting>)request.getAttribute("list");
	String advisor = (String)request.getAttribute("advisor");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
        .outer{
            width: 1400px;
            margin: auto;
            margin-top: 50px;
        }
        th{
            background-color: rgb(3,33,89);
            color: white;
        }
        tr{
        	height: 40px;
        }
        .subtitle{
        	float: left;
        }
        .advisor{
        	display: inline-block;
        	float: left;
        	margin-left:1100px
        }
        lable{
        	display: inline-block;
			float: right;
        	margin-top: 8px;
        	margin-right: 60px;
        	font-size: large;
        }
    </style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<div class="subtitle"><h4>상담내역</h4></div>
		<div class="advisor"><h4>지도교수 : </h4></div>
		<div><lable><%=advisor %></lable></div>
		
		
		<table class="listArea" border="1" style="width: 1400px;">
			<thead>
				<tr>
					<th style="width:50px; text-align: center;">순번</th>
					<th style="text-align: center;">상담 내역</th>
					<th style="width:150px; text-align: center;">상담 날짜</th>
					<th style="width:150px; text-align: center;">상담 방식</th>
					<th style="width:150px; text-align: center;">상담 시간</th>
					<th style="width:150px; text-align: center;">상담 구분</th>
				</tr>
			</thead>
			<tbody>
				<%if(list.isEmpty()){ %>
					<tr>
						<td colspan="7" style="text-align: center;">존재하는 상담 내역이 없습니다.</td>
					</tr>
				<%} else {%>
					<%for(int i=0; i<list.size();i++){ %>
						<tr>					
							<td style="text-align: center;"><%= i+1 %></td>
				 			<td><%= list.get(i).getCsContent() %></td>
				 			<td style="text-align: center;"><%= list.get(i).getCsDate() %></td>
				 			<td style="text-align: center;"><%= list.get(i).getCsWay() %></td>
				 			<td style="text-align: center;"><%= list.get(i).getCsTime() %></td>
				 			<td style="text-align: center;"><%= list.get(i).getCsType() %></td>
			 			</tr>
					<%} %>
				<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>