<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//페이지 첫 접속 시 입력창으로 포커스 이동
	$("input").eq(0).focus();
	
	//닉네임 입력 창에서 엔터 입력 시 form submit
//	$("input").eq(2).keydown(function(key) {
//		if(key.keyCode == 13) {
//			$(this).parents("form").submit();
//		}
//	})

	//로그인 버튼 클릭 시 form submit
	$("#btnJoin").click(function() {
		$(this).parents("form").submit();
	})
	
	//취소 버튼 누르면 뒤로가기
	$("#btnCancel").click(function() {
		history.go(-1);
	})
});
</script>

<style type="text/css">
form {
	width: 400px;
	margin: 0 auto;
}
</style>

<div class="container">

<h3>게시판 - 회원가입</h3>
<hr>

<form action="/kh1/join" method="post" class="form-horizontal">
	<div class="form-group">
		<label for="user_email" class="control-label">이메일</label>
		<input type="email" id="user_email" name="user_email" class="form-control"/>
	</div>
	<div class="form-group">
		<label for="user_password" class="control-label">패스워드</label>
		<input type="text" id="user_password" name="user_password" class="form-control"/>
	</div>
	<div class="form-group">
		<label for="user_nickname" class="control-label">닉네임</label>
		<input type="text" id="user_nickname" name="user_nickname" class="form-control"/>
	</div>
	<div class="form-group">
		<label for="user_name" class="control-label">이름</label>
		<input type="text" id="user_name" name="user_name" class="form-control"/>
	</div>
	<div class="form-group">
		<label for="user_birty" class="control-label">생년월일</label>
		<input type="date" id="user_birty" name="user_birth" class="form-control"/>
	</div>
	<div class="form-group">
		<label for="user_check" class="control-label">이메일 수신 동의</label>
		<input type="checkbox" id="user_check" name="user_check" class="form-control"/>
	</div>
	

	<div class="text-center">
		<button type="button" id="btnJoin" class="btn btn-primary">가입</button>
		<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
		<button type="button" id="btnCancel" class="btn btn-danger"><a href="/kh1/WebContent/WEB-INF/views/login/kakao.jsp">카카오</a></button>
				
	</div>
	
	
	<div class="text-center">
	</div>
		
</form>

<!-- .container -->
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
