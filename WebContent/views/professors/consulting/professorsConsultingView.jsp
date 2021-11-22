<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.sun.student.model.vo.Student, com.sun.student.model.vo.PageInfo"%>
<%
	ArrayList<Student> sList = (ArrayList<Student>)request.getAttribute("sList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
	#consulting-table  tfoot,
	#content-div,
	h3{
		text-align:center;
	}
	
	button {
		border-style: groove;
		border-radius: 10px;
		background: white;
		margin: left;
	}
		
	table{
		font-size:14px;
		width: max-content ;
		height: max-content ;
		margin: auto;
	}

	#insert-table input{
		height:100%;
	}
	
	#consulting-table{
		margin-top:50px;
		margin-left:5%;
		width:90%;	
		border: 3px solid #00205b;
		border-collapse: collapse; 
	}
	
	header{
		font-size:14px;
	}
	
	div{
		font-size:14px;
	}

	#consulting-table  th {
		border: 1px solid white;
		background-color: #00205b;
		color: white;
		text-align:center;
		padding : 4px;
	}
	
	#insert-table td{
		padding-left : 10px;
		padding-right : 10px;
	}
	#consulting-table  td{
		border: 1px solid #00205b;
		background-color: white;
		color: #00205b;
		padding : 4px;
	}
	
	#insert-div{
		display:inline-block;
	}

	#delete-btn,
	#update-btn{
		visibility: hidden;
		display:none;
	}

	.pagingArea{
		text-align:center;
		margin-top:10px;
	}
	#footer-div{
		position:fixed;
		text-align:center;
		height:150px; 
		bottom: 0;
    	width: 100%;
	}
</style>
</head>
<body>

	<%@ include file="../../../views/common/menubar.jsp"%>

	<header id="select-div">
	<h3>상담</h3>

	
	</header>
	
	<div id="content-div">
	<div id="insert-div">
		<table id="insert-table">
			<tr>
				<td rowspan="4">
					<label for="studentId">학생명 : </label>
					<select id="studentId">
						<%if( sList.isEmpty() ) {%>
							<option value="">학생 정보 없음</option>
						<%} else{%>
							<%for(Student s : sList){ %>
								<option value="<%=s.getUserId() %>" > <%=s.getUserName() %> (<%=s.getUserId() %>) </option>
							<%} %>
						<%} %>		
					</select>
				</td>
				<td rowspan="4">
					<button id="select-student-btn">선택</button>
				</td>
				<td><label for="consult-type" >상담 구분</label></td>
				<td><input type="text" id="consult-type" name="consult-category" placeholder="휴학상담"   disabled/></td>
				<td rowspan="4"><label for="consult-content">상담 내용</label></td>
				<td rowspan="4"><textArea id="consult-content" name="consultContent" cols="50" rows="6" style="resize: none;" disabled></textArea></td>
				<td style="display: none;"><input type="hidden" id="consult-csNo"/></td>
			</tr>
			<tr>
				<td><label for="consult-time">상담 시간</label></td>
				<td><input type="text" id="consult-time" name="consult-time" placeholder="1시간" disabled/></td>
			</tr>
			<tr>
				<td><label for="consult-date">상담 날짜</label></td>
				<td><input type="text" id="consult-date" name="consult-date" disabled readonly/></td>
			</tr>
			<tr>
				<td><label for="consult-date">상담 방식</label></td>
				<td><input type="text" id="consult-way" name="consult-way" placeholder="대면"   disabled/></td>
			</tr>
		</table>
		<br>
		<button id="insert-btn" type="submit">저장</button>
		<button id="update-btn" type="submit">수정</button>
		<button id='delete-btn' type='submit'>삭제</button>
		<br>
	</div>
	<br>
	<table id="consulting-table">
		<thead>
			<tr>
				<th>순번</th>
				<th>상담 내용</th>
				<th>상담 날짜</th>
				<th>상담 방식</th>
				<th>상담 시간</th>
				<th>상담 구분</th>
			</tr>
		</thead>
		<tbody id="consultingListArea">
		</tbody>
	</table>
	</div>
	<div id="footer-div">
		
	<div class="pagingArea" align="center">
		
	</div> 
	<br>
	<button id="area-reset-btn" style="visibility:hidden;display:none;">추가하기</button>
	</div>

	
	<br>

	<script>
	function nullCheck(){
		if($("#consult-type").val()==""){
			alert("상담 구분이 비어있습니다.");
			return false;
		}
		else if($("#consult-content").val()==""){
			alert("상담 내용이 비어있습니다.");
			return false;
		}
		else if($("#consult-time").val()==""){
			alert("상담 시간이 비어있습니다.");
			return false;
		}
		else if($("#consult-date").val()==""){
			alert("상담 날짜가 비어있습니다.");
			return false;
		}
		else if($("#consult-way").val()==""){
			alert("상담 방식이 비어있습니다.");
			return false;
		}
		
		return true;
		
		
	}


	$(function(){
		let cPage=1;
		$.datepicker.setDefaults($.datepicker.regional['ko']); 
	    $("#consult-date" ).datepicker({
	         changeMonth: true, 
	         changeYear: true,
	         nextText: '다음 달',
	         prevText: '이전 달', 
	         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
	         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
	         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	         dateFormat: "yy-mm-dd",
	         maxDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
	         onClose: function( selectedDate ) {    
	         }    

	    });
	    
	    
		/*동적으로 생긴 버튼은 이런식으로 on을 써줘야함*/
		/* consulting 테이블의 row를 클릭했을때 이벤트 발생 */
		$(document).on("click",".consulting-tr",function(){
			
			$('#delete-btn').css('display','inline-block');
			$('#update-btn').css('display','inline-block');
			$('#insert-btn').css('display','none');
			
			$('#delete-btn').css('visibility','visible');
			$('#update-btn').css('visibility','visible');
			$('#insert-btn').css('visibility','hidden');
			
			const sId= $('#studentId').val();		
			const content =$(this).children().eq(1).text();
			const date = $(this).children().eq(2).text();
			const way = $(this).children().eq(3).text();
			const time = $(this).children().eq(4).text();
			const type = $(this).children().eq(5).text();
			const csNo=  $(this).children().eq(6).text();
			
			$("#consult-type").val(type);
			$("#consult-content").val(content);
			$("#consult-time").val(time);
			$("#consult-date").val(date);
			$("#consult-way").val(way);
			$("#consult-csNo").val(csNo);
			
			setDisabledInput(false);
		});

		
		/* 추가하기 버튼 눌렀을 때 */
		$("#area-reset-btn").click(function(){
	
			$('#delete-btn').css('display','none');
			$('#update-btn').css('display','none');
			$('#insert-btn').css('display','inline-block');
			
			$('#delete-btn').css('visibility','hidden');
			$('#update-btn').css('visibility','hidden');
			$('#insert-btn').css('visibility','visible');
			
			emptyValue();
			setDisabledInput(false);
			
		})
		
		
		/* 추가 버튼 눌렀을때*/
		$("#insert-btn").click(function(){
			let check=nullCheck();
			console.log("check:"+check);
			if(check){
				$.ajax({
					url:"insertConsulting.pr",
					data:{
						sId:$("#studentId").val(),
						type:$("#consult-type").val(),
						content:$("#consult-content").val(),
						time:$("#consult-time").val(),
						date:$("#consult-date").val(),
						way:$("#consult-way").val()
					},
					type:"post",
					success:function(){
						selectConsultingList(cPage);
						alert("저장이 완료되었습니다.");
					},
					error:function(){
						console.log("ajax 통신 실패");
					}
				});
			}
			
		});
	
		
		
		/* 수정하기 버튼 눌렀을 때 */
		$("#update-btn").click(function(){
			let check=nullCheck();
			if(check){
			if(confirm("수정하시겠습니까?\n(수정하시려면 '확인', 수정하지 않으려면 '취소'를 누르십시오.) ")){
				$.ajax({
					url:"updateConsulting.pr",
					data:{
						sId:$("#studentId").val(),
						type:$("#consult-type").val(),
						content:$("#consult-content").val(),
						time:$("#consult-time").val(),
						date:$("#consult-date").val(),
						way:$("#consult-way").val(),
						csNo:$("#consult-csNo").val()
					},
					type:"post",
					success:function(){
						selectConsultingList(cPage);
						
						emptyValue();
						setDisabledInput(true);
						
						alert("수정이 완료되었습니다.");
					},
					error:function(){
						console.log("ajax 통신 실패");
					}
				});
			  
			 }
			 else{
			 	alert('수정을 취소합니다.');
			 }
			
			}
		});
	
		/* 삭제 버튼 눌렀을 때 */
		$("#delete-btn").click(function(){
			if(confirm("삭제하시겠습니까?\n(삭제하시려면 '확인', 삭제하지 않으려면 '취소'를 누르십시오.) ")){
				$.ajax({
					url:"deleteConsulting.pr",
					data:{
						csNo:$("#consult-csNo").val()
					},
					type:"post",
					success:function(){
						selectConsultingList(cPage);
						emptyValue();
						setDisabledInput(true);
						alert("삭제가 완료되었습니다.");
					},
					error:function(){
						console.log("ajax 통신 실패");
					}
				});
			 }
			else{
				alert('삭제를 취소합니다.');
			}
			
		});
		
		/* 학생 선택 후 선택 버튼 클릭 시  */
		$("#select-student-btn").click(function(){
			emptyValue();
			setDisabledInput(false);
			selectConsultingList(1);
			style='visibility:hidden;display:none;'
			$('#area-reset-btn').css('visibility','visible');
			$("#area-reset-btn").css("display", 'inline-block');
		})
	
	})
	

	function selectConsultingList(cPage){
		$("#consultingListArea").empty();
		$.ajax({
			url:"selectConsultingList.pr",
			data:{
				sId:$("#studentId").val(),
				currentPage:cPage
			},
			type:"get",
			success:function(result){
				console.log(result);
				const pi=result.pi;
				const list=result.sc;
				
				console.log(pi.listLimit);
				$.each(list, function(index, obj){
					const csNo= $("<td  class='no-td' style='visibility:hidden;display:none;position:absolute;'>").text(obj.csNo);
					const idx= $("<td  class='index-td'>").text(index+1+pi.boardLimit*(cPage-1));
					const date = $("<td  class='date-td'>").text(obj.csDate);
					const content = $("<td  class='content-td'>").text(obj.csContent);
					const time = $("<td  class='time-td'>").text(obj.csTime);
					const way = $("<td  class='way-td'>").text(obj.csWay);
					const type = $("<td  class='type-td'>").text(obj.csType);
					
					
					const tr = $("<tr class='consulting-tr'>").append(idx, content, date, way , time, type,csNo);
					$("#consultingListArea").append(tr);
					
					
				});
				pagingSetting(pi);
			},
			error:function(){
				console.log("ajax 통신 실패");
			}
			
		})
	}
	
	function pagingSetting(pi){
		cPage=pi.currentPage;
		$(".pagingArea").empty();

		//맨처음 <<
		let startBtn=$("<button onclick='selectConsultingList(1);'>");
		$(".pagingArea").append(startBtn.text("<<"));
		
		
		//이전페이지 <
		if(pi.currentPage == 1){
			$(".pagingArea").append($("<button disabled>").text("<"));
		}
		
		else{
			$(".pagingArea").append($("<button onclick='selectConsultingList("+(cPage-1)+");'>").text("<"));
		}
		
		//페이지 목록 1,2,3,...
		for(let p=pi.startPage; p<=pi.endPage; p++){
			if(p==pi.currentPage){
				$(".pagingArea").append($("<button disabled>").text(p));
			}
			else{
				$(".pagingArea").append($("<button onclick='selectConsultingList("+p+");'>").text(p));	
			}
		}
		
		//다음페이지로 >
		if(pi.currentPage == pi.maxPage){
			$(".pagingArea").append($("<button disabled>").text(">"));
		}
		else{
			$(".pagingArea").append($("<button onclick='selectConsultingList("+(cPage+1)+");'>").text(">"));
		}
		
		//맨 끝 페이지로 >>
		$(".pagingArea").append($("<button onclick='selectConsultingList("+(pi.maxPage)+");'>").text(">>"));
		
		$(".pagingArea button").css("margin","4px");
	}
	
	function emptyValue(){
		$("#consult-type").val("");
		$("#consult-content").val("");
		$("#consult-time").val("");
		$("#consult-date").val("");
		$("#consult-way").val("");
		$("#consult-csNo").val("");
	}
	
	function setDisabledInput(flag){
		$("#consult-type").attr("disabled", flag);
		$("#consult-content").attr("disabled", flag);
		$("#consult-time").attr("disabled", flag);
		$("#consult-date").attr("disabled", flag);
		$("#consult-way").attr("disabled", flag);
		
	}
	</script>
</body>
</html>