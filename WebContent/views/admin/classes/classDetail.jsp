<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sun.classes.model.vo.*, java.util.*"%>
<%
Classes classes = (Classes) request.getAttribute("classes");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Classes Detail</title>
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

form{
	margin:auto;
}

 b:hover{
 	text-decoration : underline;
 }
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp"%>
	<br>
	<h4 align="center">강의 정보 수정</h4>
	<h5 align="center">강의 목록으로 돌아가시려면 <b id = "back" onclick="location.href='list.class'"><mark>여기</mark></b>를 클릭하세요</h5>
	<div class="wrap" align="center">
		<table>
			<thead> 
				<tr>
					<td class="head">강의번호</td>
					<td class="head">강의명</td>
					<td class="head">강의실</td>
					<td class="head">강의타입</td>
					<td class="head">담당교수</td>
					<td class="head">개설연도</td>
					<td class="head">개설학기</td>
					
				</tr>
			</thead>
			<tbody class = "classes">
				<%
				if (classes == null) {
				%>

				<tr>
					<td colspan="7">존재하는 강의가 없습니다.</td>
				</tr>

				<%
				} else {
				%>
				<tr>
					<td><%=classes.getClassNo()%></td>
					<td><%=classes.getClassName()%></td>
					<td><%=classes.getClassPlace()%></td>
					<td><%=classes.getClassTypeName()%></td>
					<td><%=classes.getpName()%></td>
					<td><%=classes.getClassYear()%></td>					
					<td><%=classes.getClassSemester()%></td>	
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<br>
		
		<div class="classUpdate" align="left">

				<form  id="update" action="<%=contextPath%>/update.class" method="post">
				
					<input type="text" name="changeNO" value="<%=classes.getClassNo()%>" hidden="true"></input>
					
					<label for="className">&nbsp;&nbsp; 강의명 &nbsp;&nbsp; : &nbsp;&nbsp;</label>
					<input type="text" name="changeName" placeholder="변경할 강의명 입력" required></input> 
					&nbsp;&nbsp;
					<button type="submit">수정하기</button>
				</form>
				

				<h4>강의 정보 삭제</h4>
			<form id="delete" action="<%=contextPath%>/delete.class" method="get">
				<input type="text" name="classNo" value="<%=classes.getClassNo()%>"
					hidden="true"></input> &nbsp;&nbsp; 위 강의 정보를 삭제하시려면
				<button type="submit">삭제하기</button>
				를 눌러주세요.
			</form>
			

				<br><br>
				
			</div>
		
		</div>
</body>
</html>
			
			