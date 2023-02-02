<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<!-- 구글 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">


<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	color: #000;
}

.contents1 {
	font-size: 20px;
	font-weight: lighter;
}

.contents3 {
	font-size: 14px;
	font-weight: 100;
}

.contents_bold {
	font-size: 18px;
	font-weight: bold;
}

.result {
	font-size: 24px;
}

.intro_bg {
	display: flex;
	width: 100%;
	height: 753px;
}

.video-area {
	display: block;
	margin: auto;
}

.intro_bg video {
	margin: auto;
}

.header {
	top: 0;
	display: flex;
	width: 100%;
	margin: auto;
	height: 86px;
	background: rgba(0, 0, 0, 0.4);
	/* 	background: black; */
	position: fixed;
	z-index: 3;
	font-family: 'Noto Sans KR', sans-serif !important;
	list-style: none;
	border-collapse: collapse;
}

.header_logo {
	margin-top: -10px;
	margin-left: 95px;
	position: absolute;
}

.login {
	color: #fff;
}

.login>form>button {
	font-size: 16px;
	margin-top: 25px;
	margin-left: 110px;
	padding: 5px;
	background: rgba(112, 205, 213, 1.0);
	color: white;
	border: none;
	border-radius: 5px;
	font-family: 'Noto Sans KR', sans-serif !important;
	cursor: pointer;
}

.join {
	color: #fff;
}

.join>button {
	color: #fff;
	font-size: 16px;
	margin-top: 25px;
	padding: 5px;
	color: white;
	border: none;
	border-radius: 5px;
	font-family: 'Noto Sans KR', sans-serif !important;
	background: orange;
	cursor: pointer;
}

.nav {
	display: flex;
	justify-content: flex-end;
	line-height: 86px;
	width: calc(1280px - 400px);
	padding-left: 0px;
	margin-left: 310px;
	list-style: none;
}

.nav>li:not(:first-child) {
	margin-left: 80px;
}

.nav>li:first-child {
	
}

.nav>li>a {
	color: #fff;
	text-decoration: none !important;
}

.nav>li>a:hover {
	color: orange;
}

footer {
	display: flex;
	background: #1f1f1f;
	padding: 30px;
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
}

footer>div:first-child {
	flex: 3;
	text-align: center;
	color: #fff;
	margin-top: -7px;
}

footer>div:last-child {
	flex: 9;
	color: #fff;
}

footer>div:first-child>img {
	position: absolute;
	left: 120px;
	margin-top: -18px;
	width: 100px;
}

.navbar_togleBtn {
	display: none;
	position: fixed;
	left: 110px;
}

.navbar_togleBtn>button {
	margin: 25px;
	padding: 5px;
	font-size: 16px;
	background: green;
	color: white;
	border: none;
	border-radius: 5px;
	font-family: 'Noto Sans KR', sans-serif !important;
	font-size: 16px;
	cursor: pointer;
}

@media screen and (max-width: 1450px ) {
	.intro_bg {
		height: 100%;
	}
	.header {
		flex-direction: column;
		align-items: flex-start;
	}
	.header_logo {
		position: fixed;
		margin-left: 20px;
	}
	.nav {
		flex-direction: column;
		align-items: flex-start;
		padding: 0;
		margin: 86px auto;
		text-align: center;
		background: rgba(0, 0, 0, 0.4);
		width: 100%;
		display: none;
	}
	.nav>li {
		text-align: center;
		width: 100%;
		margin: 0 auto;
		display: inline-block;
	}
	.nav>li:not(:first-child) {
		margin-left: 0px;
	}
	.nav>li>a {
		font-size: 15px;
	}
	.login {
		position: fixed;
		right: 89px;
	}
	.login>form {
		padding: 0;
		outline: none;
	}
	.join {
		position: fixed;
		right: 20px;
	}
	.video-area {
		margin-top: 0;
	}
	.navbar_togleBtn {
		display: block;
	}

	.main_text0 {
		margin-top: 0;
	}
	.service {
		width: 100%;
		margin: 0 auto;
	}
	.service:last-child {
		margin-bottom: 50px;
	}
	.nav.active {
		display: flex;
	}
}

.mypage {
	position: fixed;
	right: 91px;
}

.mypage>button {
	margin-top: 25px;
	padding: 5px;
	/* 	background: skyblue; */
	background: rgba(112, 205, 213, 1.0);
	color: white;
	border: none;
	border-radius: 5px;
	font-family: 'Noto Sans KR', sans-serif !important;
	font-size: 16px;
	cursor: pointer;
}

.logout {
	position: fixed;
	right: 22px;
}

.logout>form>button {
	color: #fff;
	margin-top: 25px;
	padding: 5px;
	background: orange;
	color: white;
	border: none;
	border-radius: 5px;
	font-family: 'Noto Sans KR', sans-serif !important;
	font-size: 16px;
	cursor: pointer;
}

</style>

<script type="text/javascript" src="/resources/script/media_query.js"
	defer></script>

</head>
<body>

	<div class="wrap">
		<div class="intro_bg2"
			style="width: 100%; height: 200px; background: black;">
			<div class="header">
				<div class="header_logo">
					<a href="/main"> <img width=100px;
						src='/resources/img/header_logo2.png' />
					</a>
				</div>
				<ul class="nav">
					<li><a href="/official/main">칵테일 검색</a></li>
					<li><a href="/custom/main">칵테일 제작</a></li>
					<li><a href="/free/list">자유게시판</a></li>
					<li><a href="/shopping/main">쇼핑</a></li>
					<li><a href="/searchbar">어디가서 마실까</a></li>
					<li><a href="/qna/write">문의게시판</a></li>
				</ul>

				<div class="navbar_togleBtn">
					<button class="btn btn-success">MENU</button>
				</div>

				<c:if test="${empty login or not login }">
					<div class="login">
						<form>
							<button type="reset" onclick='location.href="/mypage/main";'
								class="btn btn-info">로그인</button>
						</form>
					</div>
					<div class="join">
						<button type="reset" class="btn btn-warning"
							onclick='location.href="/kh1/logout";'>회원가입</button>
					</div>
				</c:if>

				<c:if test="${login }">
					<div class="mypage">
						<button type="reset" onclick='location.href="/mypage/main";'
							class="btn btn-info">마이페이지</button>
					</div>
					<div class="logout">
						<form>
							<button type="reset" class="btn btn-warning"
								onclick='location.href="/kh1/logout";'>로그아웃</button>
						</form>
					</div>
				</c:if>

			</div>
		</div>
	</div>

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<c:import url="/WEB-INF/views/layout/mypagenav.jsp" />
<div style="display: inline-block; width: 700px; position: relative;">


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