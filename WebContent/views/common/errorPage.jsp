<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String message = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
</head>
<body>
	<h1 align="center"><%=message %></h1>
	<div align="center">
		<button onclick ="location.href='<%=request.getContextPath()%>'" style="width:50%">홈으로 돌아가기</button>
	</div>
	
</body>
</html>