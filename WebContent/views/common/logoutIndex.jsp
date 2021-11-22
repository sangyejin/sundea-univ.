<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
body {
	background-image: url('resources/images/loginBackground.png');
	background-size: cover;
}
.outer {
	width:1200px;
	margin: auto;
	margin-top:3%;
	
}
form {
	margin-top: 20px;
	margin-left: 100px;
}

td {
	padding-top: 10px;
	padding-right: 8px;
}
#main-container {
	margin-left: 10%;
	width: 500px;
	height: 350px;
	border: 1px solid #f0ffff;
	background-color: #f0ffff;
	display:inline-block;
}
#login-text {
	font-size: 75px;
	margin-top: 50px;
	margin-left:30px;
}
#main-logo, #main-img {
	display: block;
}
p{
	display:inline-block;
}
#lock-div {
	margin-top: 50px;
	margin-left: 10px;
}
#lock-img {
	display: inline-block;
	vertical-align: text-bottom;
}
#serviceZone{
	position:absolute;
	left:49%;
	top:35%;
}
#find-div{
	width:400px;
	height: 200px;
	display:inline-block;
	border-radius: 20px;
	background-color: navy;
	text-align:center;
}
#service-text{
	font-size: 50px;
	color: white;
}
#login-btn{
	width:80px;
	height:80px;
	border-radius:50%;
	background-color: #ffd400;
	color:white;
	border: 1px #ffd400;
}

</style>
<script>
	function loginVaildate() {
		if ($("#userId").val().trim().length == 0) {
			alert("아이디를 입력하세요");
			$("#userId").focus();
			return false;
		}
		if ($("#userPwd").val().trim().length == 0) {
			alert("비밀번호를 입력하세요");
			$("#userPwd").focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="outer">
		<div id="main-div">
			<img id="main-logo" src="resources/images/sunLogo1.png" alt=""
				width="200px">
		</div>
		<div id="main-container">
			<div id="lock-div">
				 <span id="login-text" style="color:#ffd400;"><B>LOGIN</B></span>
				<p style="font-size: 15px;">
					순대학교 <d style="color:navy;"><B>학사관리시스템</B></d>에<br> 오신 것을 환영합니다
				</p>
			</div>
			<form id="loginForm" action="<%=request.getContextPath()%>/login"
				method="post" onsubmit="return loginVaildate();">
				<table>
					<tr>
						<th><img id="lock-img" src="resources/images/loginIcon.png" alt=""></th>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="userId" name="userId" placeholder="아이디"></td>

						<td rowspan="2">&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" id="login-btn"><B>LOGIN</B></button></td>
					</tr>
					<tr>
						<th><img id="lock-img" src="resources/images/pwdIcon.png" alt=""></th>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="userPwd" name="userPwd" placeholder="비밀번호"></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="serviceZone">
			<div id="find-div">
			<span id="service-text"><B>ServiceZone</B></span>
				<br><br>
				<img id="lock-img" src="resources/images/foundID.png" alt="">
				<a onclick="findId();" style="text-align:left;"><B>학번/교직원 번호 찾기</B></a><br>
				<br>
				<img id="lock-img" src="resources/images/foundPWD.png" alt=""> 
				<a onclick="resetPwd();"><B>비밀번호 초기화</B> </a>
			</div>
		</div>


	</div>
	<script>
	function findId(){
		window.open("<%=request.getContextPath()%>/findIdForm.us","아이디 찾기","width=500, height=300");
	}
	function resetPwd(){
		window.open("<%=request.getContextPath()%>/resetPwdForm.us","비밀번호 초기화","width=500, height=300");
	}
	</script>

</body>
</html>