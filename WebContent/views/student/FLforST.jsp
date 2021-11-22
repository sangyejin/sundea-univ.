<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.sun.student.model.vo.*"%>
<%
ArrayList<Fluctuation> fl = (ArrayList<Fluctuation>) request.getAttribute("fl");
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
	border: 1px rgb(2, 34, 89) solid
}
table {
	width: max-content height= max-content margin= auto
}
.head {
	background: rgb(2, 34, 89);
	color: white;
}
caption {
	padding: 0;
}
td {
	text-align: center;
	color: rgb(2, 34, 89);
}
button {
	/*color: white;*/
	border-style: groove;
	border-radius: 10px;
	background: white;
	margin: left;
}
button:hover {
	background: rgb(224, 224, 224);
	border-style: groove;
	border-radius: 10px;
}
label, input {
	color: rgb(2, 34, 89);
}
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp"%>
	<%--<%@ include file="/views/admin/student/stmenu.jsp"%> --%>
	<br>
	<div class="wrap" align="center">
		<!-- 학적 -->
		<h4 align="center">학적 변동 사항</h4>
				<hr>
		
		<h6 align="center"><b id = "back" onclick="history.go(-1)"><mark>여기</mark></b>를 클릭하시면 이전 화면으로 돌아갑니다.</h6>
		
		<br>
		<table>
			<thead>
				<tr>
					<td class="head">식별번호</td>
					<td class="head">학번</td>
					<td class="head">변동사항</td>
					<td class="head">변동사유</td>
					<td class="head">연도</td>
					<td class="head">학기</td>
					<td class="head">변동일자</td>
				</tr>
			</thead>
			<tbody class="fl">
				<%
				if (fl == null) {
				%>
				<tr>
					<td colspan="7">존재하는 학적 변동 사항이 없습니다.</td>
				</tr>
				<%
				} else {
				%>
				<%
				for (Fluctuation all : fl) {
				%>
				<tr>
					<td><%=all.getFlNo()%></td>
					<td><%=all.getsId()%></td>
					<td><%=all.getFlChange()%></td>
					<td><%=all.getFlReason()%></td>
					<td><%=all.getFlYear()%></td>
					<td><%=all.getFlSemester()%></td>
					<td><%=all.getFlDate()%></td>
				</tr>
				<%
				}
				%>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<!-- 
	<script type="text/javascript">
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var bno = $(this).children().eq(0).text();
			})
		});
	</script> -->
</body>
</html>