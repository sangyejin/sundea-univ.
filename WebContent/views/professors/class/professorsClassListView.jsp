<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.sun.classes.model.vo.Classes, com.sun.student.model.vo.PageInfo"%>
<%
	ArrayList<Classes> list = (ArrayList<Classes>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage= pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage=pi.getStartPage();
	int endPage=pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
button {
	border-style: groove;
	border-radius: 10px;
	background: white;
	margin: left;
}
#class-table {
	margin-top: 50px;
	margin-left:5%;
	width: 90%;
	border: 3px solid #00205b;
	border-collapse: collapse; /* 내부 테두리 없애기 */
}

table th {
	border: 1px solid white;
	background-color: #00205b;
	color: white;
	padding : 10px;
	text-align:center;
}
table td{
	border: 1px solid #00205b;
	background-color: white;
	color: #00205b;
	padding : 4px;
	text-align:center;
}
#top-div{
text-align:center;

}

.pagingArea button{
	margin:4px;
}
</style>
</head>
<body>
	<%@ include file="../../../views/common/menubar.jsp"%>
	<div id="top-div">
	<h3>강의</h3>
		<form id="searchClassForm" action="<%=contextPath%>/classList.pr" method="post">
			<label for="cName">강의명 : </label>
			<input type="text" maxlength="10" id="cName" name="cName"></input>
			<button id="search" onclick="searchClass();">검색</button>
			<button id="search" onclick="resetClassList();">목록 초기화</button>
		</form>
	</div>
	<table id="class-table">
		<thead>
			<tr>
				<th>순번</th>
				<th>강의번호</th>
				<th>연도</th>
				<th>학기</th>
				<th>강의명</th>
				<th>이수구분</th>
				<th>강의실</th>
			</tr>
		</thead>
		<tbody>
			<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 강의가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(int i=0; i<list.size();i++){ %>
					<tr>
						<td><%= i+1 %></td>
						<td><%= list.get(i).getClassNo() %></td>
						<td><%= list.get(i).getClassYear() %></td>
						<td><%= list.get(i).getClassSemester() %></td>
						<td><%= list.get(i).getClassName() %></td>
						<td><%= list.get(i).getClassTypeName()%></td>
						<td><%= list.get(i).getClassPlace() %></td>
					</tr>
					<%} %>
				<%} %>	
		</tbody>
	</table>
	<br>
	<br>
	<div class="pagingArea" align="center">
			<!-- 맨 처음으로 (<<) -->
			<button onclick="location.href='<%=contextPath%>/classList.pr?currentPage=1'"> &lt;&lt; </button>
		
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= contextPath %>/classList.pr?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			<!-- 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=contextPath %>/classList.pr?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= contextPath %>/classList.pr?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
		
			<!-- 맨 끝으로 (>>) -->
			<button onclick="location.href='<%=contextPath%>/classList.pr?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
	</div> 
	<script>
		function searchClass(){
			if($("#cName").val()!=""){
				location.href='classList.pr';
			}
		}
		
		function resetClassList(){
			$("#cName").val("");
			location.href='classList.pr';
		}
	</script>
</body>
</html>