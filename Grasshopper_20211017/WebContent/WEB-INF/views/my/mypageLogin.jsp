<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />



<form action="/mypage/login" method="post" class="form-horizontal">
	<div style="padding-top: 300px;">
		<label for="user_email">이메일</label> <input type="text" id="user_email"
			name="user_email" />
	</div>
	<div style="margin: 0 auto;">
		<label for="user_password">패스워드</label> <input type="text"
			id="user_password" name="user_password" />
	</div>

	<div>
		<button type="button" id="btnLogin">로그인</button>
		<button type="button" id="btnCancel">취소</button>
	</div>

</form>

<script type="text/javascript">
	$(document).ready(function() {
		//페이지 첫 접속 시 입력창으로 포커스 이동
		$("input").eq(0).focus();

		//패스워드 입력 창에서 엔터 입력 시 form submit
		$("input").eq(1).keydown(function(key) {
			if (key.keyCode == 13) {
				$(this).parents("form").submit();
			}
		})

		//로그인 버튼 클릭 시 form submit
		$("#btnLogin").click(function() {
			$(this).parents("form").submit();
		})

		//취소 버튼 누르면 뒤로가기
		$("#btnCancel").click(function() {
			history.go(-1);
		})

	});
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />

