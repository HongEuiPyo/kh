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


<style>
* {
	text-decoration: none;
}

ul {
	list-style: none;
	padding: 0;
}

.nav1 {
	background-color: #eeeeee;
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-top: 100px;
}

.nav1 ul {
	display: flex;
	align-items: center;
}

.nav1 ul img {
	margin-right: 10px;
	width: 25px;
	height: 25px;
	border-radius: 50%;
}

span {
	font-size: 50px;
}

.profileWrap {
	width: calc(100% - 200px);
	height: 600px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.profileWrap img {
	border-radius: 50%;
	width: 300px;
	height: 300px;
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
			<div class="nav1">
				<h2>마이페이지</h2>
				<ul>
					<li><img
						src="https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20211001_182%2F1633066482259uo9kQ_JPEG%2F34202317086291954_1790555242.jpg&type=sc960_832"
						alt="관리자" /></li>
					<li><strong>관리자</strong> <br>
						<button onclick='location.href="/mypage/logout";'>로그아웃</button></li>
				</ul>
			</div>
			<div class="content">
				<h1>
					<a href="/qna/admin">문의 내역 보기</a>
				</h1>

				<div class="profileWrap">
					<img
						src="https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20211001_182%2F1633066482259uo9kQ_JPEG%2F34202317086291954_1790555242.jpg&type=sc960_832"
						alt="관리자" />
					<p>
						<span>관리자 나야 나~!~!</span>
					</p>
				</div>
			</div>
			<c:import url="/WEB-INF/views/layout/footer.jsp" />