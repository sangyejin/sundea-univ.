<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sun.classes.model.vo.*"%>
<%
	Classes classes = (Classes)request.getAttribute("classes");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Classes</title>
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
	width: 1000px;
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
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp"%>
	<br>
	<div class="wrap" align="center">
		<table>
			<caption>검색 결과</caption>
			<thead>
				<tr>
					<td class="head">강의번호</td>
					<td class="head">강의명</td>
					<td class="head">강의실</td>
					<td class="head">강의타입</td>
					<td class="head">담당교수</td>
					<td class="head">개설연도</td>
					<td class="head">개설학기</td>
					<td class="head">학점</td>
					
				</tr>
			</thead>
			<tbody>
				<% if(classes==null){ %>

				<tr>
					<td colspan="8">존재하는 강의가 없습니다.</td>
				</tr>

				<% }else{  %>
				<tr>
					<td><%=classes.getClassNo()%></td>
					<td><%=classes.getClassName()%></td>
					<td><%=classes.getClassPlace()%></td>
					<td><%=classes.getClassTypeName()%></td>
					<td><%=classes.getpName()%></td>
					<td><%=classes.getClassYear()%></td>					
					<td><%=classes.getClassSemester()%></td>
					<td><%=classes.getCredit()%></td>
					
				</tr>
				<% } %>
			</tbody>
		</table>
		<br>
		<div align="center">
		<button onclick="history.go(-1)">뒤로가기</button>
		<button onclick="location.href='form.class'">강의 추가</button>
		</div>
	</div>
	

</body>
</html>