<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.sun.student.model.vo.*"%>
<%
ArrayList<ClassHistories> list = (ArrayList<ClassHistories>) request.getAttribute("list");
int index = 1;
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
		<h4 align="center">수강 내역 조회</h4>
		<hr>
		<h6 align="center"><b id = "back" onclick="history.go(-1)"><mark>여기</mark></b>를 클릭하시면 이전 화면으로 돌아갑니다.</h6>
		
		<br>
		<table>
			<thead>
				<tr>
					<td class="head">순번</td>
					<td class="head">연도</td>
					<td class="head">학기</td>
					<td class="head">과목명</td>
					<td class="head">학점</td>
					<td class="head">이수구분</td>
					<td class="head">담당교수</td>
				</tr>
			</thead>
			<tbody class="list">
				<%
				if (list == null) {
				%>
				<tr>
					<td colspan="7">존재하는 수강 내역 변동 사항이 없습니다.</td>
				</tr>
				<%
				} else {
				%>
				
				<%
				for (int i = 0 ; i < list.size(); i++) {
				%>
				<tr>
					<td><%=index++ %></td>
					<td><%=list.get(i).getClassYear()%></td>
					<td><%=list.get(i).getClassSemester()%></td>
					<td><%=list.get(i).getClassName()%></td>
					<td><%=list.get(i).getCredit()%></td>
					<td><%=list.get(i).getTypeName()%></td>
					<td><%=list.get(i).getpName()%></td>

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