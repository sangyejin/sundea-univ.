<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String flag = (String)request.getAttribute("flag");
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
var flag= "<%=flag%>";
$(function(){
		if( flag=="Y"){
			alert("<%=msg%>");
			window.close();
		}
		else if( flag=="N" ){
			alert("<%=msg%>");
		}
})
</script>
<style>
button {
	border-style: groove;
	border-radius: 10px;
	background: white;
	margin: left;
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

<div id="content">
	<h1>비밀번호 재설정</h1>
	<form id="updatePwdForm" action="<%=request.getContextPath()%>/updatePwd.us" method="post" onsubmit="return checkPwd();">
		<table>
			<tr>
				<td><label for="userPwd" >기존 비밀번호</label>
				<td ><input type="password" name="userPwd" id="userPwd"></td>
			</tr>
			<tr>
				<td><label for="newPwd">새 비밀번호</label>
				<td><input type="password" name="newPwd" id="newPwd"></td>
			</tr>
			<tr>
				<td><label for="newPwdCheck">새 비밀번호 확인</label></td>
				<td><input type="password" name="newPwdCheck" id="newPwdCheck"></td>
			</tr>
		</table>	
		<br>
		
		<div class="btns" align="center">
			<button id="find-btn" type="submit">비밀번호 변경</button>
		</div>

	</form>
	</div>
	<script type="text/javascript">
		function checkPwd(){
			const userPwd = $("#userPwd");
			const newPwd= $("#newPwd");
			const newPwdCheck= $("#newPwdCheck");
			
			if(userPwd.val().trim()==""){
				alert("기존 비밀번호를 입력하세요");
				userPwd.focus();
				return false;
			}
			if(newPwd.val().trim()==""){
				alert("새 비밀번호를 입력하세요");
				newPwd.focus();
				return false;
			}
			if(newPwdCheck.val().trim()==""){
				alert("새 비밀번호 확인을 입력하세요");	
				newPwdCheck.focus();
				return false;
			}
			if(newPwd.val()!=newPwdCheck.val()){
				alert("새 비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
				newPwdCheck.focus();
				return false;
			}
			return true;
		}

	</script>
</body>
</html>