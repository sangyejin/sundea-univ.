<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.sun.student.model.vo.*"%>

<%
	ArrayList<Certificate> list = (ArrayList<Certificate>) request.getAttribute("list");
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

tbody>td:hover{
	background: rgb(224, 224, 224);
	
}

#nullContent { 
pointer-events: none; 
}

</style>
</head>
<body>
	<%--<%@ include file="/views/common/studentMenubar.jsp"%>	 --%>
	<%@ include file="/views/common/menubar.jsp"%>
	<%--<%@ include file="/views/admin/student/stmenu.jsp"%> --%>
	<br>
	<div class="wrap" align="center">
	<h4 align="center">자격증 추가 및 삭제</h4>
	<hr>
	<h6 align="center">행 선택시 해당 자격증 취득 내역 삭제가 가능합니다.</h6>
	<h6 align="center"><b id = "back" onclick="location.href='StudentAcademic'"><mark>여기</mark></b>를 클릭하시면 이전 화면으로 돌아갑니다.</h6>
	
			<div align="right">
				<button id = "add "onclick="location.href='form.ct'"> 추가 </button>
			</div>
		<table>
			<thead>
				<tr>
					<td class="head">순번</td>
					<!-- <td class="head">학번</td> -->
					<td class="head">자격명</td>
					<td class="head">발행처</td>
					<td class="head">취득일</td>
					<td class="head">첨부파일</td>
					<td class="head">식별번호</td>
				</tr>
			</thead>
			<tbody>
					<%
					if (list.isEmpty()) {
					%>

					<tr>
						<td colspan="6" id="nullContent" >존재하는 자격증 정보가 없습니다.</td>
					</tr>

					<%
					} else {
					%>
					<%
					for (Certificate ct : list) {
					%>
					<tr>
						<td><%=ct.getCfNo()%></td>
						<%--<td><%=ct.getsId()%></td>--%>
						<td><%=ct.getCfName()%></td>
						<td><%=ct.getCfIssue()%></td>
						<td><%=ct.getCfDate()%></td>
						<td><%=ct.getCfAttachment()%></td>
						<td><%=ct.getCfId()%></td>
					</tr>
					<%
					}
					%>
					<%
					}
					%>
				</tbody>
		</table>
		<br>
		<script>
		$(document).ready(function() {
			$(function() {
			
				$("tbody>tr").click(function() {
					var cfNo = $(this).children().eq(0).text();
					if(confirm("삭제하시겠습니까?\n(삭제하시려면 '확인', 삭제하지 않으려면 '취소'를 누르십시오.) ")){
						location.href="<%=contextPath %>/remove.ct?cfNo="+cfNo;
					}
					else{
						alert("삭제를 취소합니다.");
					}
				})
			})
		});
		</script>
	
	</div>


</body>
</html>