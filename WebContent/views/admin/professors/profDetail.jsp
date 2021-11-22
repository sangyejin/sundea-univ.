<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sun.professors.model.vo.*, java.util.*"%>
<%
Professors prof = (Professors) request.getAttribute("prof");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Professors Detail</title>
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
	<h4 align="center">교수 정보 수정</h4>
	<h5 align="center">교수 목록으로 돌아가시려면 <b id = "back" onclick="location.href='list.prof'"><mark>여기</mark></b>를 클릭하세요</h5>
	<div class="wrap" align="center">
		<table>
			<thead> 
				<tr>
					<td class="head">교번</td>
					<td class="head">이름</td>
					<td class="head">학과</td>
					<td class="head">전화번호</td>
					<td class="head">이메일</td>
					
				</tr>
			</thead>
			<tbody class = "prof">
				<%
				if (prof == null) {
				%>

				<tr>
					<td colspan="5">존재하는 교수가 없습니다.</td>
				</tr>

				<%
				} else {
				%>
				<tr>
					<td><%=prof.getUserId()%></td>
					<td><%=prof.getUserName()%></td>
					<td><%=prof.getcName()%></td>
					<td><input id="phone-input" type="text" value="<%=prof.getpPhone()%>"></input></td>
					<td><input id="email-input" type="email" value="<%=prof.getpEmail()%>"></input></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<br>
		<br>
		<button id="update-btn" type='submit'>수정</button>
		<br>
		
			<div class="profUpdate" align="left">
				<h4>교수 정보 삭제</h4>
			<form id="delete" action="<%=contextPath%>/delete.prof" method="get">
				<input type="text" name="userId" value="<%=prof.getUserId()%>"
					hidden="true"></input> &nbsp;&nbsp; 위 교수 정보를 삭제하시려면
				<button type="submit">삭제하기</button>
				를 눌러주세요.
			</form>
			
				<br><br>
			</div>

			
		
	
			<br><br>
		</div>
			
			<script>
			$("#update-btn").click(function(){
				if(confirm("수정하시겠습니까?\n(수정하시려면 '확인', 수정하지 않으려면 '취소'를 누르십시오.) ")){
					$.ajax({
						url : "update.prof",
						type : "post",
						data : {
							pId : "<%=prof.getUserId()%>",
							phone : $("#phone-input").val(),
							email : $("#email-input").val()
							
						},
						success : function(result) {
							alert("교수정보 수정이 완료되었습니다.");
						},
						error : function() {
							console.log("서버통신실패");
						},
					})
				}
				else{
					alert("수정을 취소하였습니다.");
				}
			})
		</script>
		
		<hr>
		
		</div>
	</div>
</body>
</html>