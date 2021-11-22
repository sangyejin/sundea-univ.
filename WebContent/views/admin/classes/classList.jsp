<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.sun.classes.model.vo.*"%>
<%
ArrayList<Classes> list = (ArrayList<Classes>) request.getAttribute("list");

PageInfoclass pi = (PageInfoclass) request.getAttribute("pi");

int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Classes Information</title>
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
	margin : left;
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
	<br>
	<div class="wrap" align="center">
		<h4 align="center">강의 목록</h6>
		<h5 align="center">수정하고자 하는 강의를 선택하면 정보 수정이 가능합니다.</h5>
		<table>
		<div align = "left">
		<form id="searchForm" action="<%=contextPath%>/search.class" method="post">
			<label for="search">강의번호로 검색 &nbsp;&nbsp; : &nbsp;&nbsp;</label>
			<input type="text" maxlength="10" name="search"></input>
			<button id = "search" onclick="location.href='search.class'">검색하기</button>
		</form>
		<br><br>
		</div>
		<!-- <caption>강의 목록</caption> -->
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
				<%
				if (list.isEmpty()) {
				%>

				<tr>
					<td colspan="8">존재하는 강의가 없습니다.</td>
				</tr>

				<%
				} else {
				%>
				<%
				for (Classes classes : list) {
				%>
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
				<%
				}
				%>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<br>
	<script>
		$(document).ready(function() {
			$(function() {
				$("tbody>tr").click(function() {
					var classNo = $(this).children().eq(0).text();
					location.href="<%=contextPath%>/detail.class?classNo="+classNo;
				})
			})
		});
	</script>

	<!-- 페이징바 만들기 -->
	<div class="pagingArea" align="center">
		<!-- 맨 처음으로 (<<) -->
		<button
			onclick="location.href='<%=contextPath%>/list.class?currentPage=1'">
			&lt;&lt;</button>

		<!-- 이전페이지로(<) -->
		<%
		if (currentPage == 1) {
		%>
		<button disabled>&lt;</button>
		<%
		} else {
		%>
		<button
			onclick="location.href='<%=contextPath%>/list.class?currentPage=<%=currentPage - 1%>'">
			&lt;</button>
		<%
		}
		%>

		<!-- 페이지 목록 -->
		<%
		for (int p = startPage; p <= endPage; p++) {
		%>

		<%
		if (p == currentPage) {
		%>
		<button disabled>
			<%=p%>
		</button>
		<%
		} else {
		%>
		<button
			onclick="location.href='<%=contextPath%>/list.class?currentPage=<%=p%>'">
			<%=p%>
		</button>
		<%
		}
		%>

		<%
		}
		%>

		<!-- 다음페이지로(>) -->
		<%
		if (currentPage == maxPage) {
		%>
		<button disabled>&gt;</button>
		<%
		} else {
		%>
		<button
			onclick="location.href='<%=contextPath%>/list.class?currentPage=<%=currentPage + 1%>'">
			&gt;</button>
		<%
		}
		%>

		<!-- 맨 끝으로 (>>) -->
		<button
			onclick="location.href='<%=contextPath%>/list.class?currentPage=<%=maxPage%>'">
			&gt;&gt;</button>
	
	<br><br>
		<button onclick="location.href='form.class'">강의 추가</button>
		
	</div>
		
	
</body>
</html>