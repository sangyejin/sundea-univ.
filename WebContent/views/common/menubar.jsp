<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sun.user.model.vo.User"%>

<%
User loginUser = (User) session.getAttribute("loginUser");
String msg = (String) session.getAttribute("msg");
String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" />
<style>

<!--login이 되어있을 때의 style -->


#top{
	
}

 #logo { 
 	display:block-inline;
	padding-right: 75%;
	text-decoration-line: none;
}

#login-user-name, #logout {
	font-size: 12px;
}

#topMenu {
	height: 50px;
	width: 100%;
	background-color: #00205b;
}

#topMenu ul li {
	list-style: none;
	color: white;
	background-color: #00205b;
	float: left;
	line-height: 50px;
	vertical-align: middle;
	text-align: center;
	margin-left: 10%;
}

#topMenu .menuLink {
	text-decoration: none;
	color: white;
	display: block;
	width: 125px;
	font-size: 12px;
	font-weight: bold;
}

#topMenu .menuLink:hover {
	color: #092d70;
	background-color: white;
}

#logo:link {text-decoration: none;}
#logo:visited {text-decoration: none;}
#logo:hover {text-decoration:  none;}

nav {
	height: 5%;
}
nav {
	background-color: rgb(3, 33, 89);
	margin: 5px 0px;
}
nav>ul {
	list-style-type: none;
	margin-right: 300px;
	padding: 0;
	height: 100%;
}
nav li {
	float:left;
	width: 15%;
	/*margin: 10%;*/
	height: 100%;
	text-align: center;
	font-size: 18px;
	line-height: 35px;
	margin: auto;
	
}
/*
div{
 border: 1px solid red;
}*/

</style>


<script>
	$( function(){
		var msg="<%=msg%>";
		if (msg != "null") {
			alert(msg);
			<%session.removeAttribute("msg");%>
	}
	})

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
		<%
		if (loginUser == null) {
		%>
			<%@ include file="../common/logoutIndex.jsp" %>
		<%
		} else {
		%>
		<div id="top" style="background-color:white;">
			<a id='logo' href="<%=contextPath%>"> <img src="resources/images/sunLogo1.png" width="140px" height="70px"></a> 
			<span id="login-user-name"> <%=loginUser.getUserName() %>님
			<%if(Character.toUpperCase(loginUser.getUserId().charAt(0)) != 'A'){ %>
				<a onclick="updatePwd();">비밀번호 변경</a>
			<%} %>
			<a href = "<%=contextPath%>/logout">로그아웃</a></span>
		
	<nav id="topMenu">
	<%
	if (Character.toUpperCase(loginUser.getUserId().charAt(0)) == 'A') { //관리자
	%>
	<div align="right" >
	<ul>
		<li><div class="menuLink" onclick="goStudentManagement();">학생 관리</div></li>
		<li><div class="menuLink" onclick="location='<%=contextPath%>/list.prof'">교수 관리</div></li>
		<li><div class="menuLink" onclick="location='<%=contextPath%>/list.class'">강의 관리</div></li>
	</ul>
	</div>
	<%
	} else if (Character.toUpperCase(loginUser.getUserId().charAt(0)) == 'P') { //교수
	%>
	<div align="right">
	<ul>
		<li><div class="menuLink" onclick="goProfessorsClass();">강의</div></li>
		<li><div class="menuLink" onclick="goProfessorsGrade();">성적</div></li>
		<li><div class="menuLink" onclick="goProfessorsConsulting();">상담</div></li>
	</ul>
	</div>
	<%
	} else { // 학생
	%>
	<div align="left">
	<ul>
		<li><div id = "4" class="menuLink" onclick="goStudentRegister();">학적</div></li>
		<li><div id = "4" class="menuLink" onclick="goStudentConsulting();">상담</div></li>
		<li><div id = "4" class="menuLink" onclick="goStudentGrade();">성적</div></li>
		<li><div id = "4" class="menuLink" onclick="goCertification('https://www.webminwon.com/#reload');">증명서발급</div></li>
	</ul>
	</div>
	
	<%}}%>
	</nav>
	</div>
	<script>
    
   function goStudentManagement(){
		location.href="<%=request.getContextPath()%>/list.st";
	}
	
	function goProfessorsClass(){
		location.href="<%=request.getContextPath()%>/classList.pr";
	}

	function goProfessorsGrade(){
		location.href="<%=request.getContextPath()%>/gradeList.pr";
	}
	
	function goProfessorsConsulting(){
		location.href="<%=request.getContextPath()%>/consultingList.pr";
	}
	
	function goStudentRegister(){
		location.href="<%=request.getContextPath()%>/StudentAcademic";
	}
	
	function goStudentConsulting(){
		location.href="<%=request.getContextPath()%>/student.consult";
	}
	
	function goStudentGrade(){
		location.href="<%=request.getContextPath()%>/student.grade";
		
	}
	
	function goCertification(url) {
        var win = window.open(url, '_blank');
        win.focus();
    }
	
	function updatePwd(){
		window.open("<%=request.getContextPath()%>/updatePwdForm.us","비밀번호 초기화","width=500, height=300");
	}
	</script>
</body>
</html>