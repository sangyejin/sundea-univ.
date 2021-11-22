<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.sun.student.model.vo.*,com.sun.professors.model.vo.*"%>

<%
	ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student</title>
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
	<h4 align="center">교수추가</h4>
	<hr>
	<div align="center">
	<p>학과 선택 후 확인 버튼을 누르면 교수 번호가 발급됩니다.</p>
		<form id="enrollForm" action="<%=request.getContextPath()%>/insert.prof" method="post" onsubmit="return joinValidate();">
			<table>
				<tr>
					<td width="200px">학과</td>
					<td width="200px">
						<select name="categoryNo" id="categoryNo">
							<option value="" hidden selected>학과 선택</option>
						<%if(categoryList.isEmpty()){ %>
							<option value="">학과가 존재하지않습니다.</option>
						<%}else{ %>
							<%for(Category c : categoryList) {%>
								<option value="<%=c.getCategoryNo() %>"><%=c.getCategoryName() %>(<%=c.getCategoryNo() %>)</option>
							<%} %>
						<%} %>
						</select>
					</td>
					<td>
						<button onclick="selectCategory();">확인</button>
					</td>
				</tr>
				<tr>
					<td width="200px">교수번호</td>
					<td><input type="text" maxlength="10" name="userId" readonly></td>
					</td>
				</tr>
				<tr>
					<td width="200px">비밀번호</td>
					<td width="200px"><input type="password" maxlength="10" name="userPwd" required></td>
					<td></td>
				</tr>
				<tr>
					<td  width="200px">교수이름</td>
					<td  width="200px"><input type="text" name="userName" required></td>
				</tr>
					
				
				<tr>
					<td width="200px">이메일</td>
					<td width="200px"><input type="email" name="pEmail"></td>
				</tr>
					<tr>
					<td  width="200px">전화번호</td>
					<td  width="200px"><input type="text" name="pPhone"></td>
				</tr>
				
			</table>
			<br>
	<div align="center">
			<button type="button" id="goMain" onclick="history.go(-1)">교수목록</button>
			<button type="submit" id="joinBtn" disabled>추가하기</button>
	</div>
		</form>
	</div>
	<script>
		function selectCategory(){
			if($("#categoryNo").val()==""){
				alert("학과를 선택 후 확인버튼을 눌러주세요.");
				$("#categoryNo").focus();
			}else{

				$.ajax({
					url : "autoCreateId.ad",
					type : "post",
					data : {
						categoryNo:$("#categoryNo").val()
					},
					success : function(result) {
						console.log(result);
						$("#enrollForm input[name=userId]").val(result);
						$("#joinBtn").attr("disabled", false);
					},
					error : function() {
						console.log("ajax 통신 오류");
					},
				})
			}

		}
		
		function joinValidate(){
				if(!(/^[가-힣]{2,}$/.test($("#enrollForm input[name=userName]").val()))){
					 $("#enrollForm input[name=userName]").focus();
			        return false;
				 }
	
				 return true;
						
			}

	</script>
		
</body>
</html>