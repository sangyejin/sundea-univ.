<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User u = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
/*
body{
		background:url('<%=request.getContextPath()%>/resources/images/bgd2.png') no-repeat; 
		background-size:cover;
	}*/
</style>
</head>
<body>
	<%@ include file="views/common/menubar.jsp" %>
	<% if(u!=null){%>	
		<%@ include file="views/common/index.jsp" %>
	<%} %>
</body>
</html>