<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sun.student.model.vo.*"%>
<%
	Student st = (Student)request.getAttribute("st");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
div {
	/*border: 1px solid red;*/
	box-sizing: border-box;
	display: block;
}

header {
	align: left;
}

nav {
	height: 5%;
}

nav {
	background-color: rgb(3, 33, 89);
	margin: 5px 0px;
}

nav>ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	height: 100%;
}

nav li {
	/*float: left;*/
	width: 20%;
	height: 100%;
	text-align: center;
	font-size: 18px;
	line-height: 35px;
	margin: left;
}

.wrap {
	width: 1200px;
	margin: auto;
}

.wrap>* {
	width: 100%;
}

table, .head, td {
	border: 1px rgb(2,34,89) solid
}

table {
	width: max-content height= max-content margin= auto
}

.head {
	background: rgb(2,34,89);
	color: white;
}

caption {
	padding: 0;
	text-align: left;
}

td {
	text-align: center;
	color : rgb(2,34,89);
}

button{
	/*color: white;*/
	border-style: groove;
	border-radius: 10px;
	background : white;
	
}

button:hover{
	background : rgb(224,224,224);
	border-style: groove;
	border-radius: 10px;
}
label, input{
	margin : left;
	color : rgb(2,34,89);
}

#nullContent { 
pointer-events: none; 
}

</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp"%>
	<br>
	<div class="wrap" align="center">
	<h4 align="center">학번으로 검색한 결과</h4>
		<h5 align="center"><mark>학생을 선택하면 학적 정보 수정이 가능합니다.</mark></h5>
		<table>
			<thead>
				<tr>
					<td class="head">학번</td>
					<td class="head">이름</td>
					<td class="head">학년</td>
					<td class="head">학과</td>
					<td class="head">학부</td>
					<td class="head">지도교수</td>
				</tr>
			</thead>
			<tbody>
				<% if(st==null){ %>

				<tr>
					<td colspan="6" id="nullContent" >존재하는 학생이 없습니다.</td>
				</tr>

				<% }else{  %>
				<tr>
					<td><%=st.getUserId() %></td>
					<td><%=st.getUserName() %></td>
					<td><%=st.getsLevel() %>학년</td>
					<td><%=st.getcName() %></td>
					<td><%=st.getDeptName() %></td>
					<td><%=st.getpName() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<br>
		<div align="center">
		<button onclick="location.href='list.st'">학생 목록</button>
		<button onclick="location.href='form.st'">학생 추가</button>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$(function() {
				$("tbody>tr").click(function() {
					var userId = $(this).children().eq(0).text();
					location.href="<%=contextPath%>/detail.st?userId="+userId;
				})
			})
		});
	</script>
	

</body>
</html>