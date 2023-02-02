<style type="text/css">
content_area {
	margin-top: 85px;
	}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />


<%@page import="java.math.BigInteger"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.security.SecureRandom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<script type="text/javascript">
$(document).ready(function() {
	//페이지 첫 접속 시 입력창으로 포커스 이동
	$("input").eq(0).focus();
	
	//패스워드 입력 창에서 엔터 입력 시 form submit
	$("input").eq(1).keydown(function(key) {
		if(key.keyCode == 13) {
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
	
	//비밀번호 찾기 버튼 클릭 시 링크 이동
	$("#btnFind").click(function() {
		location.href="../WEB-INF/views/login/find.jsp";
	})
	
});
</script>


<style type="text/css">
.content_area {
	margin-top: 85px;
	}

form {
	width: 400px;
	margin: 0 auto;
}
/* content_area {
	width: 100px;
	margin: 100px;
	padding: 100px;
} */

</style>

<div class="space"></div>

<section>
<div class="container">

<form action="/kh1/login" method="post" class="form-horizontal">
	
	<div class="form-group">
		<label for="user_email" class="control-label">이메일</label>
		<input type="email" id="user_email" name="user_email" class="form-control"/>
	</div>
	
	
	<div class="form-group">
		<label for="user_password" class="control-label">패스워드</label>
		<input type="text" id="user_password" name="user_password" class="form-control"/>
	</div>

	<div class="text-center">
		<button type="button" id="btnLogin" class="btn btn-primary">로그인</button>
		<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
		
		<br>
		<br>
		
		
		
		
		<button type="button" class="btn btn-default"><a href="<%=request.getContextPath() %>/kh1/join">회원 가입</a></button>
		<button type="button" class="btn btn-default"><a href="<%=request.getContextPath() %>/kh1/login/find">비밀번호 찾기</a></button>

		<hr>
		
				
		<c:import url="/WEB-INF/views/login/kakao.jsp" />
		<c:import url="/WEB-INF/views/login/naver.jsp" />
		<c:import url="/WEB-INF/views/login/google.jsp" />
		<c:import url="/WEB-INF/views/login/facebook.jsp" />
		
	</div>
	
	<hr>
	
</form>
</div>
</section>









<c:import url="/WEB-INF/views/layout/footer.jsp" />
