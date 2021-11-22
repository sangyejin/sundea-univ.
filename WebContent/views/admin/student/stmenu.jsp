<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sun.student.model.vo.Student"%>
<%
Student st = (Student) request.getAttribute("st");
Student stp = (Student) request.getAttribute("stp");

String emp = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer {
	width: 90%;
	margin: auto; //
	margin-top: 50px;
}
/*
	.outer>*{
		width: 100%;
	}*/
th {
	background-color: rgb(3, 33, 89);
	color: white;
	border: 1px solid white;
	width: 200px;
}


tr {
	height: 20px;
}

td {
	text-align: center;
	color: rgb(3, 33, 89);
	width: 200px;
}

ul li {
	list-style: none;
	float: left; //
	line-height: 25px;
	vertical-align: middle;
	text-align: center;
	margin-left: 15%;
}

ul>li:hover{
	background: rgb(247, 243, 223);
	//border-style: groove;
	//border-radius: 10px;
}

.category {
	aling: center;
	//margin-left: 50px;
	font-size: 15px;
}

.wrap {
	float: left; //
	margin-left: 100px;
}

h5 {
	text-align: left;
}

</style>
</head>
<body>
	<%@ include file="/views/common/menubar.jsp"%>
	<br>
	<br>
	<div class="outer">

		<div class="wrap" align="center">
			<h5>
				<B>*학적조회</B>
			</h5>
			<table border="1">
				<tr>
					<th style="text-align: center;">학번</th>
					<td><%=st.getUserId()%></td>
					<th style="text-align: center;">이름</th>
					<td><%=st.getcName()%></td>
					<th style="text-align: center;">학년</th>
					<td><%=st.getsLevel()%></td>
				</tr>
				<tr>
					<th style="text-align: center;">학부</th>
					<td><%=st.getDeptName()%></td>
					<th style="text-align: center;">학과</th>
					<td><%=st.getcName()%></td>
					<th style="text-align: center;">지도교수</th>
					<td><%=st.getpName()%></td>
				</tr>
				<tr>
					<th style="text-align: center;">입학년도</th>
					<td colspan="3"><%=st.getSEDate()%></td>
					<th style="text-align: center;">취득학점</th>
					<td colspan="3"><%=st.getSumCredit()%></td>
				</tr>
			</table>
			<br>
			<hr>
			<div class="category">
				<ul style="">
					<li onclick="location.href='stPersonal.sel'"><B><u>신상 정보 수정</u></B></li>
					<li onclick="location.href='stpage.fl'"><B><u>학적 변동</u></B></li>
					<li onclick="location.href='stpage.ch'"><B><u>수강 내역</u></B></li>
					<li onclick="location.href='ct.st'"><B><u>자격증</u></B></li>
				</ul>
			</div>
			<br>
			<hr>
			<h5>
				<B>*신상정보</B>
			</h5>
			<table border="1">
				<tr>
					<th style="text-align: center;">핸드폰번호</th>
					<%
					if (st.getsPhone() != null) {
					%>
					<td><%=st.getsPhone()%></td>
					<%
					} else {
					%>
					<td><%=emp%></td>
					<%
					}
					%>
					<th style="text-align: center;">이메일</th>
					<%
					if (st.getsEmail() != null) {
					%>
					<td><%=st.getsEmail()%></td>
					<%
					} else {
					%>
					<td><%=emp%></td>
					<%
					}
					%>
					<th style="text-align: center;">병역</th>
					<%
					if (stp.getMilitary() != null) {
					%>
					<td><%=stp.getMilitary()%></td>
					<%
					} else {
					%>
					<td><%=emp%></td>
					<%
					}
					%>
				</tr>
				<tr>
					<th style="text-align: center;">주소</th>
					<%
					if (stp.getAddress() != null) {
					%>
					<td colspan="5"><%=stp.getAddress()%></td>
					<%
					} else {
					%>
					<td colspan="5"><%=emp%></td>
					<%
					}
					%>
				</tr>
			</table>
			<br> <br>
			<h5>
				<B>*계좌구분</B>
			</h5>
			<table border="1">
				<tr>
					<th style="text-align: center;">계좌번호</th>
					<%
					if (stp.getAccount() != null) {
					%>
					<td><%=stp.getAccount()%></td>
					<%
					} else {
					%>
					<td><%=emp%></td>
					<%
					}
					%>
					<th style="text-align: center;">은행명</th>
					<%
					if (stp.getBank() != null) {
					%>
					<td><%=stp.getBank()%></td>
					<%
					} else {
					%>
					<td><%=emp%></td>
					<%
					}
					%>
					<th style="text-align: center;">예금주</th>
					<%
					if (stp.getHolder() != null) {
					%>
					<td><%=stp.getHolder()%></td>
					<%
					} else {
					%>
					<td><%=emp%></td>
					<%
					}
					%>
				</tr>
			</table>
			<br> <br> <br> <br>
		</div>

	</div>
</body>
</html>