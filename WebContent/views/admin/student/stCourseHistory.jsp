<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
table {
width: "300";
align= "center";
}
</style>
</head>
<body>
<%@ include file="/views/admin/student/stmenu.jsp"%>
 <div class="wrap">
		
		<table border="2">		 
		 <tr>
                <td class="head">자격증</td>
                <td><%=st.getUserId()%></td>
                <td class="head">병역</td>
                <td></td>
                <td class="head">입학년도</td>
                <td><%=st.getSEmail()%></td>
        </tr>
		    <tr>
				<td class="head">이름</td>
				<td><%=st.getUserName()%></td>
				<!--<td>휴학학기</td>
				 <td></td>-->
				<td class="head">핸드폰 번호</td>
				<td><%=st.getSPhone()%></td>
		    </tr>
		     <tr>
				<td class="head">학부</td>
				<td><%=st.getCNo()%></td>
				<td class="head">입학일</td>
				<td><%=st.getSEDate()%></td>
		    </tr>
		     <tr>
				<td class="head">학년</td>
				<td><%=st.getsLevel()%></td>
				<td class="head">지도 교수</td>
				<td><%=st.getPId()%></td>
			<!-- <td></td>-->
			<!-- <td></td>-->
		    </tr>
		     <!--  <tr>
				<td></td>
				<td></td>
				<td>입학년도(과정년도)</td>
				<td></td>
				<td></td>
				<td></td>
		    </tr>
		    <tr>
				<td></td>
				<td></td>
				<td>취득 학점</td>
				<td></td>
				<td></td>
				<td></td>
		    </tr>-->
		
		</table>
		</div>	
</body>
</html>