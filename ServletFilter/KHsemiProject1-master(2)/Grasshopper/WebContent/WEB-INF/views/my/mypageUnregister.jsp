<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<c:import url="/WEB-INF/views/layout/mypagenav.jsp" />
<div style="display: inline-block; width: 700px;">


<div id="box">
	<h1>정말요...?</h1>
	<h1>가...지....마......세요......</h1>
</div>

<div>
	<form action="/mypage/unregister" method="post">

		<div>
			<label for="password">패스워드</label> <input type="password"
				id="password" name="password" />
		</div>

		<div>
			<button type="button" id="btnUnregister">탈퇴</button>
			<button type="button" id="btnCancel">취소</button>
		</div>
	</form>
</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {

		$(document).ready(function() {
			//페이지 첫 접속 시 입력창으로 포커스 이동
			$("input").eq(0).focus();
		});
		
		//탈퇴버튼 동작
		$("#btnUnregister").click(function() {
			$("form").submit();
		});

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});

	});
</script>


<c:import url="/WEB-INF/views/layout/footer.jsp" />