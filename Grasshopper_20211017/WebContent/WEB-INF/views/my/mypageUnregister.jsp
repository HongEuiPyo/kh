<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 마시지 -</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/resources/css/headerfooter.css">

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

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

<style type="text/css">
form {
	width: 400px;
	margin: 0 auto;
}

button {
	margin: 0 auto;
}

#box {
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding-top: 250px;
}

h1 {
	font-size: xx-large;
	color: red;
}
</style>


</head>

<body>
	<div class="wrap">
		<div class="intro_bg">
			<div class="header">
				<div class="header_logo">
					<a href="/main"> <img width=100px;
						src='/resources/img/header_logo2.png' />
					</a>
				</div>
				<ul class="nav">
					<li><a href="/main">칵테일 검색</a></li>
					<li><a href="/main">칵테일 제작</a></li>
					<li><a href="/main">커뮤니티 게시판</a></li>
					<li><a href="/main">자유게시판</a></li>
					<li><a href="/main">쇼핑</a></li>
					<li><a href="/main">문의게시판</a></li>
				</ul>
				<div class="login">
					<form>
						<button>로그인</button>
					</form>
				</div>
				<div class="join">
					<button>회원가입</button>
				</div>
			</div>
		</div>
		<div class="content_area">

			<div id="box">
				<h1>정말요...?</h1>
				<h1>가...지....마......세요......</h1>
			</div>

			<div>
				<form action="/mypage/unregister" method="post">

					<div>
						<label for="password">패스워드</label> <input type="text"
							id="password" name="password" />
					</div>

					<div>
						<button type="button" id="btnUnregister">탈퇴</button>
						<button type="button" id="btnCancel">취소</button>
					</div>
				</form>
			</div>


			<c:import url="/WEB-INF/views/layout/footer.jsp" />