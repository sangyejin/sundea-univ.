<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.sun.student.model.vo.*,com.sun.professors.model.vo.* "%>

<%
	ArrayList<Student> cList = (ArrayList<Student>)request.getAttribute("cList");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
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

.outer {
	background: white;
	width: 600px;
	height: 500px;
	margin-top: 50px;
	margin-left: auto;
	margin-right: auto;
	color: black;
}

#enrollForm {
	/* border:1px solid white; */
	width: 100%;
	margin-left: auto;
	margin-right: auto;
}

#enrollForm td:nth-child(1) {
	text-align: right;
}

#enrollForm input {
	margin: 3px;
}
</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp"%>
	<br><br>
	<h4 align="center">자격증 추가</h4>
	<hr>
	<div align="center">
		<form id="enrollForm" action="<%=request.getContextPath()%>/add.ct" method="post">
			<table>
				<tr>
					<td width="200px">식별번호</td>
					<td><input type="text" name="cfNo" placeholder="정수만 입력" required></td>
					<td><input type="text" name="sId" value="<%=loginUser.getUserId() %>" hidden="true"></td>
				</tr>
				<tr>
					<td width="200px">자격명</td>
					<td width="200px"><input type="text" name="cfName" required></td>
					<td></td>
				</tr>
				<tr>
					<td  width="200px">발행처</td>
					<td  width="200px"><input type="text" name="cfIssue" required></td>
				</tr>
				<tr>
				<td  width="200px">취득일</td>
				<td  width="200px"><input type="date" name="cfDate" placeholder="YYYYMMDD" required></input> </td>
				</tr>
				<tr>
					<td width="200px">증빙자료</td>
					<td width="200px"><input type="file" name="cfAttachment" required></td>
				</tr>
				<tr>
					<td width="200px">자격번호</td>
					<td width="200px"><input type="text" name="cfId" required></td>
				</tr>
			</table>
			<br>
	<div align="center">
			<button type="button" id="goMain" onclick="history.go(-1)">뒤로가기</button>
			<button type="submit" id="joinBtn">추가하기</button>
	</div>
		</form>
	</div>
<%--
	<script>
		function joinValidate(){
				
				if(!(/^[a-z][a-z\d]{3,11}$/i.test($("#enrollForm input[name=userId]").val()))){
					$("#enrollForm input[name=userId]").focus();
			        return false;
				}
				
				if(!(/^[가-힣]{2,}$/.test($("#enrollForm input[name=userName]").val()))){
					 $("#enrollForm input[name=userName]").focus();
			        return false;
				 }
				 
				 return true;
						
			}
	
			function checkId() {
				var userId = $("#enrollForm input[name=userId]");
				if (userId.val() == "") {
					alert("학번을 입력해주세요.");
					return false;
				}
				$.ajax({
					url : "idCheck.me",
					type : "post",
					data : {
						userId : userId.val()
					},
					success : function(result) {
						if (result == "fail") {
							if (confirm("올바른 학번입니다. 자격증을 추가하시겠습니까?")) {
								userId.attr("readonly", "true");
								$("#joinBtn").removeAttr("disabled");
							} else {
								userId.focus();
							}
							
						} else {
							alert("존재하지 않는 학번입니다. 다시 확인해주세요.");
							userId.focus();
							userId.val("");
						}
					},
					error : function() {
						console.log("서버통신실패");
					},
				})
			}
			
		</script>
	 --%>
</body>
</html>