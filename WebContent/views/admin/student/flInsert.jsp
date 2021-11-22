<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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
	<br>
	<h4 align="center">학적 변동 사항 추가</h4>
	<hr>
	<div align="center">
		<form id="enrollForm" action="<%=request.getContextPath()%>/insert.fl"
			method="post">
			<table>
				<tr>	
					<td width="200px">학번 </td>
					<td width="200px"><input type="text" id = "sId" name="sId" placeholder="2021101001" required></input></td>
					<td  width="200px"><button type="button" id="idCheckBtn" onclick="checkId();" disabled>학생확인</button>
					</td>
					<td><label id="userIdResult"></label></td>
				</tr>
				<tr>
					<td width="200px">식별번호</td>
					<td><input type="text" name="flNo" id="flNo"
						required></input></td>
						<td><label id="flNoResult"></label></td>
				</tr>
				<tr>
					<td width="200px">변동사항</td>
					<td width="200px"><input type="text" name="flChange" id="flChange" required></input></td>
					<td></td>
				</tr>
				<tr>
					<td width="200px">변동사유</td>
					<td width="200px"><input type="text" name="flReason" id="flReason" required></input></td>
				</tr>

				<tr>
					<td width="200px">연도</td>
					<td width="200px"><input type="text" maxlength="4"
						name="flYear" id="flYear" ></input></td>
						<td><label id="flYearResult"></label></td>
				</tr>
				<tr>
					<td width="200px">학기</td>
					<td width="200px"><input type="text" maxlength="1"
						name="flSemester" id="flSemester" ></input></td>
					<td><label id="flSemesterResult"></label></td>
						
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="button" id="goMain" onclick="history.back()">뒤로가기</button>
				<button type="submit" id="joinBtn" disabled>추가하기</button>
			</div>
		</form>
	</div>
	<script>
        $(function(){
            $('#flNo').keyup(function(){
                var regExp = /^[1-9]$/g;
                if(!regExp.test($(this).val())){
                    $("#flNoResult").html("1-9 사이의 정수만 입력").css("color","red");
                    $(this).focus().css("background","salmon");
                }else{
                    $("#flNoResult").html("적합").css("color","blue");
                    $(this).focus().css("background","white");
                }
              });
          
          // $(function(){
                $('#sId').keyup(function(){
                    var regExp2 = /^[0-9]{10}$/g;
                    if(!regExp2.test($(this).val())){
                        $("#userIdResult").html("10자리의 숫자만 입력").css("color","red");
                        $(this).focus().css("background","salmon");
                       // $('#idCheckBtn').attr('disabled');
                    }else{
                        $("#userIdResult").html("적합, 학생 존재 유무 확인 필요").css("color","blue");
                        $(this).focus().css("background","white");
                        $('#idCheckBtn').removeAttr('disabled');
                    }
                  })
                  
                  $('#flYear').keyup(function(){
                    var regExp3 = /^[0-9]{4}$/g;
                    if(!regExp3.test($(this).val())){
                        $("#flYearResult").html("4자리의 연도만 입력").css("color","red");
                        $(this).focus().css("background","salmon");
                       // $('#idCheckBtn').attr('disabled');
                    }else{
                        $("#flYearResult").html("적합").css("color","blue");
                        $(this).focus().css("background","white");
                       // $('#pIdCheckBtn').removeAttr('disabled');
                    }
                  })
                  
                   $('#flSemester').keyup(function(){
                    var regExp4 = /^[1-2]{1}$/g;
                    if(!regExp4.test($(this).val())){
                        $("#flSemesterResult").html("정수의 학기만 입력").css("color","red");
                        $(this).focus().css("background","salmon");
                       // $('#idCheckBtn').attr('disabled');
                    }else{
                        $("#flSemesterResult").html("적합").css("color","blue");
                        $(this).focus().css("background","white");
                       // $('#pIdCheckBtn').removeAttr('disabled');
                    }
                  })
                 
        })
    </script>
	
	<script>
	function checkId() {
				var userId = $("#enrollForm input[name=sId]");
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
							if (confirm("존재하는 학번입니다. 이 학번에 학적을 추가하시겠습니까?")) {
								userId.attr("readonly", "true");
								$("#joinBtn").removeAttr("disabled");
							} else {
								userId.focus();
							}
						} else {
							alert("존재하지 않는 학번입니다.");
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
</body>
</html>