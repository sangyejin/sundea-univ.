<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String uId = (String) request.getAttribute("userId");
String flag = (String) request.getAttribute("flag");
String msg= (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
var uId="<%=uId%>";
$(function(){
		if(uId != "null"){
			alert("아이디는 [ <%=uId%> ]입니다.");
			window.close();
		}
		if("<%=flag%>" == "N" & "<%=msg%>"!="null") {
			alert("<%=msg%>");
		}
	})
</script>
<style>
body{
	background-color:#f0ffff;
}
button {
	margin-bottom:10px;
	border-style: groove;
	border-radius: 20px;
	border:1px #ffd400;
	background: #ffd400;
	margin: left;
	color: white;
	width:150px;
	height: 30px;
}
#find{
	background-color:navy;
	color:white;
	font-weight:800px;
	border: 3px solid navy;
}
.outer{
	margin:auto;
	background-color:white;
}
table{
	margin-left: 28%;
}

h1{
	font-size:14px;
	background-color:#00205b;
	color:white;
	padding-top:4px;
	padding-bottom:4px;
}
#content{
	text-align:center;
}
table {
    margin:auto; 
}
</style>
</head>
<body>

	<div id="find"><b> > 학번/교원번호 찾기</b></div>

	<br>

	<div class="outer">
		<form id="findIdForm" action="<%=request.getContextPath()%>/findId.us" method="post" onsubmit="return checkNull();">
			<table>
				<tr>
					<th><label>교원/학생</label></th>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<td><input type="radio" name="tableName" value="Professors">교원</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="tableName" value="Student"checked="checked">학생</input></td>
				</tr>
				<tr>
					<th><label for="userName">이름</label></th>
					<td><input type="text" name="userName" id="userName"></td>
				</tr>
				<tr>
					<th><label for="userEmail">이메일</label></th>
					<td><input type="email" name="userEmail" id="userEmail"></td>
				</tr>
			</table>
			<br> <br>

			<div class="btns" align="center">
				<button id="find-btn" type="submit"><B>학번/교원번호 찾기</B></button>
			</div>

		</form>
	</div>


	</form>
</div>	

	<script type="text/javascript">
		function checkNull() {
			const userName = $("#userName");
			const userEmail = $("#userEmail");

			if (userName.val().trim() == "") {
				alert("이름을 입력하세요");
				return false;

			}
			if (userEmail.val().trim() == "") {
				alert("이메일을 입력하세요");
				return false;
			}
			console.log(userName + userEmail);
			//$("#findIdForm").submit();
		
			return true;

			
		}
	</script>

</body>
</html>