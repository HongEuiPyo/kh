<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>오늘 뭐 마시지 - </title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/resources/css/mainstyle.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<style>
.carousel-inner>.carousel-item>img {
	width: 569px;
	height: 426.75px;
}
</style>

<!-- <link rel="stylesheet" type="text/css" href="/resources/css/headerfooter.css"> -->

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

</head>

<body>
	<div class="wrap">
		<div class="header">
				<ul class="nav">
					<li>
						<div class="header_logo">
							<a href="/main"> <img width=100px;
								src='/resources/img/header_logo2.png' />
							</a>
						</div>
					</li>
					<li><a href="/official/main">칵테일 검색</a></li>
					<li><a href="/custom/main">칵테일 제작</a></li>
					<li><a href="/free/list">자유게시판</a></li>
					<li><a href="/shopping/main">쇼핑</a></li>
					<li><a href="/qna/write">문의하기</a></li>
					<c:if test="${empty login or not login }">
						<li>
							<div class="login">
								<form>
									<button type="reset" onclick='location.href="/kh1/login";'
										class="btn btn-info">로그인</button>
								</form>
							</div>
							<div class="join">
								<button type="reset" onclick='location.href="/kh1/join";'
									class="btn btn-warning">회원가입</button>
							</div>
						</li>
					</c:if>
					<c:if test="${login }">
						<li>
							<div class="login">
							<button type="reset" onclick='location.href="/mypage/main";' 
								class="btn btn-info">마이페이지</button>
							</div>
							<div class="join">
								<form>
									<button type="reset" class="btn btn-warning"
										onclick='location.href="/kh1/logout";'>로그아웃</button>
								</form>
							</div>
						</li>
					</c:if>
				</ul>
		</div>
	</div>

	<div class="content_area">