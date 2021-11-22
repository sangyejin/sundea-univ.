<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.sun.student.model.vo.StudentDivisionGrade, com.sun.student.model.vo.StudentSemeterGrade, com.sun.student.model.vo.StudentEarnCredit"%>
<%
	ArrayList<StudentDivisionGrade> list = (ArrayList<StudentDivisionGrade>)request.getAttribute("list");
	ArrayList<StudentSemeterGrade> SList = (ArrayList<StudentSemeterGrade>)request.getAttribute("SList");
	ArrayList<StudentEarnCredit> EList = (ArrayList<StudentEarnCredit>)request.getAttribute("EList");
	
	
	ArrayList<StudentSemeterGrade> rank = (ArrayList<StudentSemeterGrade>)request.getAttribute("rank");
	
	int totalSum = 0;
	int preSum = 0;
	int eleSum = 0;
	int prerequisiteEss = 0;
	int prerequisiteSel = 0;
	int electiveEss = 0;
	int electiveSel = 0;
	int industry = 0;
	int free = 0;
	
	int no = 1;
	int earnCredit = 0;
	int ranking = 0;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
</head>
<style>
        .outer{
            width: 1400px;
            margin: auto;
            margin-top: 50px;
        }
        th{
            background-color: rgb(3,33,89);
            color: white;
        }
        tr{
        	height: 40px;
        }
        .division{
        	margin-top:10%;
        }  
</style>
<body>
	<%@ include file="../../../views/common/menubar.jsp"%>
	<div class="outer">
		<div class="semester"><h4>학기별 성적</h4>
			<table class="listArea" border="1" style="width: 1400px;">
				<thead>
					<tr>
						<th rowspan="2" style="width:100px; text-align: center;">순번</th>
						<th rowspan="2" style="width:200px; text-align: center;">년도</th>
						<th rowspan="2" style="width:100px; text-align: center;">학기</th>
						<th colspan="5" style="text-align: center;">계</th>
					</tr>
					<tr>
						<th style="width:200px; text-align: center;">신청학점</th>
						<th style="width:200px; text-align: center;">취득학점</th>
						<th style="width:200px; text-align: center;">학기평점</th>
						<th style="width:200px; text-align: center;">백분율</th>
						<th style="width:200px; text-align: center;">전공석차</th>
					</tr>
				</thead>
				<tbody>
					<%if(SList.isEmpty()){ %>
						<td colspan="8" style="text-align:center;">존재하는 성적 내역이 없습니다.</td>
					<%}else{ %>
						<%for(int i=0;i<SList.size();i++){ %>
						<tr>
							<td style="text-align: center"><%=no++ %></td>
							<td style="text-align: center"><%=SList.get(i).getYear() %></td>
							<td style="text-align: center"><%=SList.get(i).getSemester() %></td>
							<td style="text-align: center"><%=SList.get(i).getAppliCredit() %></td>
							<%if(EList.get(i)!=null){ %>
								<%earnCredit=EList.get(i).getEarnCredit(); %>
							<%} %>
							<td style="text-align: center"><%=earnCredit%></td>
							<td style="text-align: center"><%=SList.get(i).getAvgCredit() %></td>
							<td style="text-align: center"><%=SList.get(i).getPercent() %></td>
						 	<%if(rank.get(i)!=null){ %>
								<%ranking=rank.get(i).getRank(); %>
							<%} %>
							<td style="text-align: center"><%=ranking %></td>
						</tr>
						<%} %>
								
						
					<%} %>
				</tbody>
				
			</table>
		</div>
		<div class="division"><h4>이수구분 별 취득 학점</h4>
			<table class="listArea" border="1" style="width: 1400px;">
				<thead>
					<tr>
						<th rowspan="2" style="width:140px; text-align: center;">구분</th>
						<th rowspan="2" style="width:140px; text-align: center;">전공필수</th>
						<th rowspan="2" style="width:140px; text-align: center;">전공선택</th>
						<th rowspan="2" style="width:140px; text-align: center;">교양필수</th>
						<th rowspan="2" style="width:140px; text-align: center;">교양선택</th>
						<th rowspan="2" style="width:140px; text-align: center;">산학</th>
						<th rowspan="2" style="width:140px; text-align: center;">자유</th>
						<th colspan="3" style="width:140px; text-align: center;">합계</th>
	
					</tr>
					<tr>
						<th style="width:140px; text-align: center;">전공 합계</th>
						<th style="width:140px; text-align: center;">교양 합계</th>
						<th style="width:140px; text-align: center;">총 합계</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
					<th style="text-align: center;">취득 학점</th>
					<%if(list.isEmpty()){ %>
						<td colspan="9" style="text-align: center;">존재하는 성적 내역이 없습니다</td>
					<%} else { %>
						<%for(StudentDivisionGrade sdg: list){ %>
							<%if(sdg.getClassTypeNo()==1){ %>
								<% prerequisiteEss=sdg.getClassCreditSum();%>
								<% preSum += sdg.getClassCreditSum(); %>
							<%}else if(sdg.getClassTypeNo()==2){ %>
								<% prerequisiteSel=sdg.getClassCreditSum();%>
								<% preSum += sdg.getClassCreditSum(); %>
							<%}else if(sdg.getClassTypeNo()==3){ %>
								<% electiveEss=sdg.getClassCreditSum();%>
								<% eleSum += sdg.getClassCreditSum(); %>
							<%}else if(sdg.getClassTypeNo()==4){ %>
								<% electiveSel=sdg.getClassCreditSum();%>
								<% eleSum += sdg.getClassCreditSum(); %>
							<%}else if(sdg.getClassTypeNo()==5){ %>
								<% industry=sdg.getClassCreditSum();%>
							<%}else if(sdg.getClassTypeNo()==6){ %>
								<% free=sdg.getClassCreditSum();%>
							<%} %>
							<% totalSum+=sdg.getClassCreditSum(); %>
							
						<%} %>
						<td style="text-align: center;"><%= prerequisiteEss %></td>
						<td style="text-align: center;"><%= prerequisiteSel %></td>
						<td style="text-align: center;"><%= electiveEss %></td>
						<td style="text-align: center;"><%= electiveSel %></td>
						<td style="text-align: center;"><%= industry %></td>
						<td style="text-align: center;"><%= free %></td>
						<td style="text-align: center;"><%= preSum %></td>
						<td style="text-align: center;"><%= eleSum %></td>
						<td style="text-align: center;"><%= totalSum %></td>
					<%} %>
						
					</tr>

				</tbody>
			</table>
		
		</div>
	</div>
	
</body>
</html>