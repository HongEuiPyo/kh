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



<div>
	<h3 style="text-align: center; margin-top: 20px">내 정보 수정하기</h3>
</div>

<div style="width:100%; height: 100%; position:relative; margin: 0 auto;">
<form class="form-horizontal row justify-content-md-center m1"
	action="/mypage/update" method="post" enctype="multipart/form-data"
	id="form">
	<div class="col-md-auto mt-2 mb-5" style="width: 50%; height: 100%; margin-top: 20px; margin-left: 650px;">
		<input type="hidden" name="user_no" value="${user_info.user_no }" />
		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>Email</strong></label>
			<div class="col">
				<p class="form-control-static">${user_info.user_email }</p>
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 control-label"><strong>Password</strong></label>
			<div class="col">
				<input type="password" class="form-control" id="inputPassword"
					placeholder="Password" name="user_password">
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 control-label"><strong>Nick</strong></label>
			<div class="col">
				<input type="text" class="form-control" id="inputNickname"
					value="${user_info.user_nickname }" name="user_nickname">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>Name</strong></label>
			<div class="col">
				<p class="form-control-static">${user_info.user_name }</p>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>Birth</strong></label>
			<div class="col">
				<p class="form-control-static">${user_info.user_birth }</p>
			</div>
		</div>
		<div>
			<div id="beforeFile">
				기존 첨부파일: <a href="/upload/${attachmentFile.profile_name}"
					download="${attachmentFile.profile_name }">${attachmentFile.profile_name }</a>
				<span id="delFile"
					style="color: red; font-weight: bold; cursor: pointer;">X</span>
			</div>

			<div id="afterFile">
				새 첨부파일: <input type="file" name="file" />
			</div>
		</div>
		<div class="d-grid gap-2 d-md-flex justify-content-md-center"
			style="margin-top: 15px; margin-bottom: 60px;">
			<button type="button" class="btn btn-primary me-md-2" id="btnUpdate">수정</button>
			<button type="button" id="btnCancel" class="btn btn-primary ml-1">취소</button>
		</div>
	</div>
</form>
</div>

<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td>이메일</td> -->
<%-- 			<td>${user_info.user_email }</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>비밀번호</td> -->
<!-- 			<td><input type="text" name="user_password" value="" -->
<!-- 				id="passwordCheck" /></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>닉네임</td> -->
<!-- 			<td><input type="text" name="user_nickname" -->
<%-- 				value="${user_info.user_nickname }" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>포인트</td> -->
<%-- 			<td>${user_info.user_point }</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>이름</td> -->
<%-- 			<td>${user_info.user_name }</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>생년월일</td> -->
<%-- 			<td>${user_info.user_birth }</td> --%>
<!-- 		</tr> -->

<!-- 	</table> -->


<script type="text/javascript">
	$(document).ready(function() {

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});

		$(document).ready(function() {
			//페이지 첫 접속 시 입력창으로 포커스 이동
			$("input").eq(0).focus();
		});

		$("#btnUpdate").click(function() {
			if ($("#inputPassword").val() == '') {
				alert('비밀번호를 입력해주세요');
				$('#inputPassword').focus();
			} else {
				$("#form").submit();
			}

		});

		//파일 삭제 버튼(X) 처리
		$("#delFile").click(function() {
			$("#beforeFile").toggle();
		})

	});
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
