<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
		nav{
            background-color:rgb(2, 34, 89);
            margin:5px 0px;
        }
        nav>ul{
            list-style-type: none;
            margin:0;
            padding:0;
            height:100%;
        }
        nav li{
            float:left;
            width:25%;
            height:100%;
            text-align:center;
            font-size:18px;
            line-height:35px;
        }
       nav li a{
            text-decoration:none;
            color:white;
        }
        nav li:hover{
          	color: #092d70;
			background-color: white;
			text-decoration:underline;

        }
</style>
</head>
<body>
	<!-- 
	<table id="dumbass">
			<tr>
				<td class="head">학번</td>
				<td></td>
				<td class="head">지도교수</td>
				<td></td>
				<td class="head">학과</td>
				<td></td>
			</tr>
			<tr>
				<td class="head">이름</td>
				<td></td>
				<td class="head">입학년도</td>
				<td></td>
				<td class="head">핸드폰 번호</td>
				<td></td>
			</tr>
			<tr>
				<td class="head">이메일</td>
				<td></td>
				<td class="head">학년</td>
				<td></td>
				<td class="head">이메일</td>
				<td></td>
			</tr>
		</table>
	 -->
		<nav>
            <ul>
                <li onclick="idtheft();">신상 정보</li>
                <li onclick="flucadjust()">학적 변동</li>
                <li onclick="cHistory();">수강 내역</li>
                <li onclick="certificate();">자격증</li> 
            </ul>
        </nav>
        <script>
		function idtheft(){
			location.href="<%=request.getContextPath()%>/StPersonal";
		}
	
		function flucadjust(){
			location.href="<%=request.getContextPath()%>/StAcademicFluctuations";
		}
		
		function cHistory(){
			location.href="<%=request.getContextPath()%>/StCourseHistory";
		}
		
		function certificate(){
			location.href="<%=request.getContextPath()%>/ct.st";
		}
	
		</script>
		
</body>
</html>