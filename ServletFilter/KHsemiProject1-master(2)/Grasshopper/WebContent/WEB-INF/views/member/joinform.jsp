<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<style>
button, input, textarea {
	font-size: 16px;
	padding: 4px;
	margin-bottom: 5px;
	
}

.select {
	margin-bottom: 50px; 
}

#useridchk {
	border: none;
	background-color: #FD9F28;
	color: #fff;
	border-radius: 4px;
	padding: 5px 10px;
	box-shadow: 3px 3px 3px rgba(0,0,0,0.1);
	margin-left: 5px;
}

.btn-area {
	margin-bottom: 20px;
}

#btnJoin, #btnCancel {
	border: none;
	background-color: #FD9F28;
	color: #fff;
	border-radius: 6px;
	padding: 10px 40px;
	box-shadow: 3px 3px 3px rgba(0,0,0,0.1);
}

button:focus, button:active, input:focus, input:active, textarea:focus,
	textarea:active {
	box-shadow: none;
	outline: none;
}

label {
	padding-bottom: 0px;
}

.submail {
	margin-left: 5px;
}

.form-join {
	width: 450px;
	margin: 0 auto;
}

.formid {
	display: flex;
	flex-direction: row;
}

.form-control {
    display: flex;
    width: 80%;
    padding: 10px 5px;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: 5px;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}

</style>


<script type="text/javascript">
var duplicateId = true;
var duplicateNick = true;

$(document).ready(function() {
	//페이지 첫 접속 시 입력창으로 포커스 이동
	$("input").eq(0).focus();

	//가입 버튼 클릭 시 form submit
	$("#btnJoin").click(function() {
		
		if( $("#userid").val() == '' ) {
			alert("아이디를 입력하세요")
			return false;
		}
		
		if( $("#usernick").val() == '' ) {
			alert("닉네임을 입력하세요")
			return false;
		}
		
		if( $("#userpw").val() == '' ) {
			alert("패스워드를 입력하세요")
			return false;			
		}
		
		
		if( !duplicateId && !duplicateNick ) {
			$(this).parents("form").submit();
			
		} else {
			
			if( duplicateId ) {
				alert("아이디중복검사를 수행하세요")
			}
			
			if( duplicateNick ) {
				alert("닉네임중복검사를 수행하세요")
			}
			
			return false;
		}
		
	})

	//취소 버튼 누르면 뒤로가기
	$("#btnCancel").click(function() {
		history.go(-1);
	})
	
	
	$("#usernick").keyup(function() {
		$.ajax({
			type: "get"
			, url: "/duplchk/nick"
			, data: {
				usernick: $("#usernick").val()
			}
			, dataType: "json"
			, success: function(res) {
				console.log("success ---")
				console.log(res.isDupl)
				
				if( res.isDupl == 0 ) {
					duplicateNick = false;
					
					$("#usernickChk")
						.css("color", "blue")
						.html("사용가능한 닉네임입니다")
					
				} else {
					duplicateNick = true;
					
					$("#usernickChk")
						.css("color", "red")
						.html("사용 불가능한 닉네임입니다")
				}
			}
			, error: function() {
				console.log("error")
			}
		})
	})
});



function inputIdChk() {
	console.log("#useridchk click")
	
	var userid = $("#userid").val();
	
	if( userid == null || userid == '') {
		alert("아이디를 입력하세요")
		return false;
	}
	

	if (!userid) {
			alert("도메인을 입력해주세요");
			$("#email_domain").focus();
			return false;
		}

		$.ajax({
			type : "get",
			url : "/duplchk/email",
			data : {
				userid : userid
			},
			dataType : "json",
			success : function(res) {
				console.log("success ---")
				console.log(res.isDupl)

				if (res.isDupl == 0) {
					alert("사용가능한 아이디입니다")
					duplicateId = false;
				} else {
					alert("이미 사용된, 중복된 아이디입니다")
					duplicateId = true;
				}

			},
			error : function() {
				console.log("error")
			}
		})

	}
</script>

<div class="container">
<br>
<h3 style="text-align: center;">게시판 - 회원가입</h3>
<hr>



<form class="form-join" action="/member/join" method="POST" id="myform">

	<div class="form-group">
		<label for="userid">아이디</label><br>
		<div class="formid">
		<input type="email"  class="form-control" id="userid" name="userid" required placeholder="이메일 형식으로 입력"/>
		<button type="button" value="중복확인" id="useridchk" onclick="inputIdChk()">중복확인</button>
		</div>
	</div>
	<div class="form-group">
		<label for="usernick" >닉네임</label><br>
		<input type="text" class="form-control" id="usernick" name="usernick" required placeholder="닉네임 입력"/>
		<span id="usernickChk"></span>
	</div>
	<div class="form-group">
		<label for="userpw">패스워드</label><br>
		<input type="text" class="form-control" id="userpw" name="userpw" required placeholder="패스워드 입력" />
	</div>
	<div class="form-group">
		<label for="username" >이름</label><br>
		<input type="text" class="form-control" id="username" name="username"  placeholder="이름 입력" />
	</div>
	<div class="form-group">
		<label for="userbirth" >생년월일</label><br>
		<input type="date" class="form-control" id="userbirth" name="userbirth" />
	</div>
	<div class="form-group">
		<label for="subsmail"  >홍보메일 수신 여부</label><br>
		<div class="select">
		<input type="radio" class="submail" name="subsmail" value="1" checked/> 동의  
		<input type="radio" class="submail"  name="subsmail" value="0" /> 거부
		</div>
	</div>
	<div class="btn-area" style="text-align: center;">
		<button type="button" id="btnJoin">가입</button>
		<button type="button" id="btnCancel">취소</button>
	</div>
</form>


<!-- <form action="/member/join" method="post" id="myform">

<table>
<tr>
	<td><label for="userid">아이디</label></td>
	<td>
	<input type="email" id="userid" name="userid" required placeholder="이메일 형식으로 입력"/>
	<button type="button" value="중복확인" id="useridchk" onclick="inputIdChk()">중복확인</button>
	</td>
</tr>
<tr>
	<td><label for="usernick" >닉네임</label></td>
	<td><input type="text" id="usernick" name="usernick" required placeholder="닉네임 입력"/></td>
</tr>
<tr>
	<td><label for="userpw">패스워드</label></td>
	<td><input type="text" id="userpw" name="userpw" required placeholder="패스워드 입력" /></td>
</tr>
<tr>
	<td><label for="username" >이름</label></td>
	<td><input type="text" id="username" name="username"  placeholder="이름 입력" /></td>
</tr>
<tr>
	<td><label for="userbirth" >생년월일</label></td>
	<td><input type="date" id="userbirth" name="userbirth" /></td>
</tr>
<tr>
	<td><label for="subsmail"  >홍보메일 수신 여부</label></td>
	<td>
		<input type="radio" name="subsmail" value="1" checked/>동의
		<input type="radio" name="subsmail" value="0" />거부
	</td>
</tr>
</table>
<div class="btn-area">
	<button type="button" id="btnJoin">가입</button>
	<button type="button" id="btnCancel">취소</button>
</div>
</form>
 -->
<!-- .container -->
</div>




</body>
<c:import url="/WEB-INF/views/layout/footer.jsp" />