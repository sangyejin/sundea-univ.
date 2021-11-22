<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width: 1200px;
		margin: auto;
	    margin-top: 25px;
	}
	.bor{
		margin-left:50px;
	}
	th{
       background-color: rgb(3,33,89);
       color: white;
       border: 1px solid white;
       width:200px; 
	}
	tr{
		height: 40px;
	}
	td {
		text-align: center;
		color: rgb(3,33,89);
		width:200px; 
	}
	.input{
		width:200px;
		height:40px;
	}
	#save{
		border-style: groove;
		border-radius: 10px;
		background: white;
		margin: left;
		float:right;
		width:80px;
		height:30px;
		
	}
	
	/*h4, h6{
		margin-right : 100px;
	}*/
	
	.btn{
			margin-left : 1050px;
	
	}
	/*
	#phoneResult{
	margin-left:170px;
	}
	
	#emailResult{
		margin-left:300px;
	
	}*/
</style>
</head>
<body>
<%@ include file="/views/common/menubar.jsp"%>
<div class="outer">
 	<div class="bor">
 	 	<br>
		<form id="enrollForm" action="<%=request.getContextPath()%>/stPersonal.save" method="post">
		<h4 align="center">신상 정보 수정 페이지</h4>
				<hr>
		
		<h6 align="center"><b id = "back" onclick="history.go(-1)"><mark>여기</mark></b>를 클릭하시면 이전 화면으로 돌아갑니다.</h6>
		<!--<h5><B>*상세 신상정보</B></h5>		 
		 <table border="1">
		<caption><label id="phoneResult"></label><label id="emailResult"></label></caption>
		 <tr>
                <th class="head" style="text-align: center;">핸드폰번호</th>
                <td><input type="text" class="input"  id="phone" name="phone" width="100px" required></td>
                <th class="head"   style="text-align: center;">이메일</th>
                <td><input type="email" class="input" name="email" id="email" required></td>
                <!-- <th class="head"  style="text-align: center;">병역</th>
                <td><input type="text" class="input" name="military" required></td>
        </tr>
	    <tr>
			<th class="head"  style="text-align: center;">주소</th>
            <td colspan="5"><input type="text" name="address"  maxlength= "20" style="width:1000px; height:40px" placeholder="시/도까지만 간단히 적으시오." required></td>
	    </tr>
		</table>
		<h5><B>*계좌구분</B></h5>		 
		<table border="1">
		 <tr>
                <th class="head"  style="text-align: center;">계좌번호</th>
                <td><input type="text" class="input" name="account" required></td>
                <th class="head"  style="text-align: center;">은행명</th>
                <td><input type="text" class="input" name="bank" required></td>
                <th class="head"  style="text-align: center;">예금주</th>
                <td><input type="text" class="input" name="holder" required></td>
        </tr>
		</table> -->
		<br>
		
		<div align="center">
		<label for ="phone" >핸드폰번호 &nbsp;&nbsp; : &nbsp;&nbsp; </label>
		<input type="text" class="input"  id="phone" name="phone" width="100px" required>&nbsp;&nbsp;&nbsp;
		<label id="phoneResult"></label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label for="email">이메일 &nbsp;&nbsp; : &nbsp;&nbsp; </label>
		<input type="email" class="input" name="email" id="email" required>&nbsp;&nbsp;&nbsp;
		<label id="emailResult"></label>
		</div>
		
		<div class="btn" >
				<button id="save" type="submit" disabled>등록하기</button>
		</div>
		</form>
		
	</div>
	<script>
        $(function(){
            $('#phone').keyup(function(){
                var regExp = /^\d{2,3}-\d{3,4}-\d{4}$/;

                if(!regExp.test($(this).val())){
                    $("#phoneResult").html("'-' 를 포함한 정확한 번호 입력").css("color","red");
                    $(this).focus().css("background","salmon");
                }else{
                    $("#phoneResult").html("적합").css("color","blue");
                    $(this).focus().css("background","white");
                }
              });
            
            $('#email').keyup(function(){
                var regExp2 = /^[a-z][a-z0-9_-]{3,11}@([a-z\d\.-]+)\.([a-z\.]{2,6})$/;

                if(!regExp2.test($(this).val())){
                    $("#emailResult").html("정확한 이메일 입력").css("color","red");
                    $(this).focus().css("background","salmon");
                }else{
                    $("#emailResult").html("적합").css("color","blue");
                    $(this).focus().css("background","white");
                }
              });
          
            $('#save').removeAttr('disabled');
        })
    </script>
	</div>
	<br>
	<br>
</body>
</html>