<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.ArrayList,com.sun.classes.model.vo.Classes" %>
<%	
	ArrayList<Classes> classList = (ArrayList<Classes>)request.getAttribute("classList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>순대학교 학사 관리 시스템</title>
<link href="resources/images/sunIcon.png" rel="shortcut icon" type="image/x-icon">
<style>
button {
	border-style: groove;
	border-radius: 10px;
	background: white;
	margin: left;
}
#student-table {
	margin-top: 50px;
	margin-left:5%;
	width: 90%;
	border: 3px solid #00205b;
	border-collapse: collapse; /* 내부 테두리 없애기 */
}

header{
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	background-color:white;
}

#content{
	padding-top:180px;
	margin-top:30px;
	margin-bottom:100px;
}

#footer-div{
	position:fixed;
    bottom:0;
    width:100%;
    height:70px;   
    background:white;
    text-align:right;
    border-top:3px solid #00205b;
}
#save-btn{
	margin-right:100px;
	margin-top:20px;	
}
table th {
	border: 1px solid white;
	background-color: #00205b;
	color: white;
	text-align:center;
	padding : 10px;
}

table td{
	border: 1px solid #00205b;
	background-color: white;
	color: #00205b;
	padding : 4px;
	text-align:center;
}

input{
	border: 0; 
	margin:0;
	width:100%;
	height:100%;
}

input:focus{
     outline: none;
}
#top-div{
text-align:center;

}
</style>
</head>
<body>
	<header>
	<%@ include file="../../../views/common/menubar.jsp"%>
	<div id="top-div">
	<h3>성적</h3>

	<label>강의명 : </label>
	<select id="className" name="className">
		<%if(!classList.isEmpty()){ %>
			<%for(Classes c : classList){ %>
				<option value="<%= c.getClassNo() %>"><%= c.getClassName() %>(<%= c.getClassNo() %>)</option>
			<%} %>
		<%} else{%>
			<option value="">조회된 강의가 없습니다.</option>
		<%} %>
	</select>
	<button id="select-class-btn">선택</button>
	</div>
	</header>
	<div id="content">
		<table id="student-table">
		<thead>
			<tr>
				<th>순번</th>
				<th>학번</th>
				<th>이름</th>
				<th>학과명</th>
				<th>성적</th>
			</tr>
		</thead>
		<tbody id="classHistoryListArea">
		</tbody>
	</table>
	</div>
	<div id="footer-div">
		<button id="save-btn" disabled>저장</button>
	</div>
	<script>
	let originMap= new Map();
	$(function(){
		
		/*저장버튼 눌렀을때*/
		$("#save-btn").click(function(){
			let flag=true;
			let chList=new Array();
			const trLength=	$("#student-table > tbody>tr").length;
			
			for(let i=1; i<=trLength;i++){
				
				let sId = $('#student-table>tbody>tr:nth-child('+i+')>.sId-td').text();
//				let sId = $('#student-table>tbody>tr:nth-child('+i+')>td').eq(1).text();
				let cgPoint = $('#student-table>tbody>tr:nth-child('+i+')>td>.point-input').val();
				cgPoint= cgPoint!=""? cgPoint:"0";
				
				console.log("숫자인지"+isNaN(cgPoint)+cgPoint ); // isNan으로 숫자면 false 숫자가 아니면 true
				console.log("범위내"+(cgPoint>=0 & cgPoint<=4.5));
				
				if( (isNaN(cgPoint)) || !(cgPoint>=0 & cgPoint<=4.5)){
					alert("순번 ["+i+"] 입력이 잘못되었습니다. 0 ~ 4.5 사이 숫자를 입력해주십시오.");	
					flag=false;
					break;
				}
				if(originMap.get(sId)!=cgPoint){
					chList.push(sId+","+cgPoint);
				}
			}
			
			if(flag){
				$.ajax({
					url:"updatechList.pr",
					data:{
						chList:chList,
						classNo:$("#className").val()
					},
					type:"post",
					success:function(){
						selectchList();
						alert("저장이 완료되었습니다.");
					},
					error:function(){
						console.log("ajax 통신 실패");
					}
				});
			}

		});
		
		
		/* 검색 */
		$("#select-class-btn").click(function(){
			$("#save-btn").attr("disabled", false);
			selectchList();
		})
		
	})
	
	/* 리스트 보여주는 function */
	function selectchList(){
		$("#classHistoryListArea").empty();
		$.ajax({
			url:"chList.pr",
			data:{
				cId:$("#className").val()
			},
			type:"get",
			success:function(list){
				var value="";
				
				$.each(list, function(index, obj){
					const idx = $("<td>").text(index+1);
					const sId = $("<td  class='sId-td'>").text(obj.sId);
					const sName = $("<td>").text(obj.sName);
					const cateName = $("<td>").text(obj.cateName);
					const cgPoint= $("<td>").append($("<input type='text'class='point-input'>").val(obj.cgPoint!=0?obj.cgPoint:""));
					const tr = $("<tr class='student-tr'>").append(idx,sId, sName, cateName, cgPoint);
					originMap.set(obj.sId,obj.cgPoint);
					$("#classHistoryListArea").append(tr);
					
				});
			},
			error:function(){
				console.log("ajax 통신 실패");
			}
			
		})
	}
	
	</script>


</body>
</html>