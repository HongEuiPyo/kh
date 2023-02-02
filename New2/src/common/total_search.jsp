<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>오늘 뭐 마시지 - 통합검색</title>

<!-- 구글 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">

<!-- CSS -->


<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style type="text/css">
* {
	font-family: 'Noto Sans KR', sans-serif !important;
	list-style: none;
	text-decoration: none !important;
	border-collapse: collapse;
	margin: 0px;
	padding: 0px;
	color: #000;
}

/* div { */
/* 	border: hidden !important; */
/* } */

h1 {
	font-size: 48px;
	font-weight: 100;
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
	background: rgba(0, 0, 0, 0.5);
	position: fixed;
	z-index: 3;
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
	border-radius: 1;
}

.join {
	color: #fff;
}

.join>button {
	color: #fff;
	font-size: 16px;
	margin-top: 25px;
	padding: 5px;
	border-radius: 1;
}

.search_area {
	width: 600px;
	height: 50px;
	background: rgba(255, 255, 255, 0.9);
	border-radius: 8px;
	position: absolute;
	left: 50%;
	top: 40%;
	transform: translateX(-50%);
}

.search_area>form>input {
	border: none;
	width: 550px;
	height: 50px;
	background: rgba(0, 0, 0, 0.0);
	color: black;
	padding-left: 10px;
}

.search_area>form>span {
	width: 50px;
	color: rgba(100, 100, 100, 0.8);
	font-weight: bold;
	cursor: pointer;
}

.nav {
	display: flex;
	justify-content: flex-end;
	line-height: 86px;
	width: calc(1280px - 400px);
	padding-left: 0px;
	margin-left: 310px;
}

.nav>li:not(:first-child) {
	margin-left: 84px;
}

.nav>li:first-child {
	
}

.nav>li>a {
	color: #fff;
}

.nav>li>a:hover {
	color: orange;
}

footer {
	display: flex;
	background: #1f1f1f;
	padding: 30px;
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

footer>.footer_content {
	margin-left: 270px;
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
	border-radius: 1;
}

.main {
	text-align: center;
	margin-top: 100px;
}

.main_header {
	margin: 0 auto;
	margin-top: 100px;
	width: 45%;
	height: 100px;
	text-align: center;
}

.cards {
	margin: 0 auto;
}

.cards > ul {
	margin: 0 auto;
	width: 760px;
	height: 350px;
	margin-bottom: 50px;
}

.cards > ul > li > .card_image {
	float: left;
	width: 350px;
	height: 350px;
}

.cards > ul > li > .card_content {
	float: left;
	width: 400px;
	height: 350px;
}

.card_title {
	text-align: center;
}

.card_desc {
	text-align: center;
}

.card_info {
	text-align: center;
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
		right: 91px;
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
	.search_area {
		width: 60%;
	}
	.search_area>form>input {
		width: 90%;
		margin: auto;
		margin-top: auto;
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
}

.logout {
	position: fixed;
	right: 20px;
}

.logout>form>button {
	color: #fff;
	margin-top: 25px;
	padding: 5px;
}

@media screen and (max-width: 768px ) {
	.search_area {
		position: absolute;
		top: 150px;
	}
	.search_area>form>input {
		width: 80%;
	}
}
</style>

<script type="text/javascript" src="/resources/script/media_query.js"
	defer></script>

</head>
<body>

	<div class="wrap">
		<div class="intro_bg2"
			style="width: 100%; height: 500px; background-position: center; background-position: top; background-repeat: no-repeat; background-image: url('/resources/img/cocktailbar.jpg')">
			<div class="search_area">
				<form action="/main/total_search" method="get">
					<input name="search" type="search" placeholder="오늘 뭐 마시지"
						value="${search }" /> <span style="cursor: hand"
						onclick="document.forms[0].submit()">검색</span>
				</form>
			</div>
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



	<div class="main" >
		<div style="text-align: center; margin-top: 100px">
			<h3>' ${search} ' 에 대한 검색 결과</h3>
		</div>
		<div class="main_header">
			<h3>공식 칵테일</h3>
			<hr>
		</div>
		<!-- 카드보드형태 -->
		<div class="cards" id="card">
			<c:forEach var="o" items="${list }">
				<ul>
					<li>
					<div class="card_image">
						<img width="350px" height="350px"
							src="/resources/img/official_cocktail/official_cocktail_${o.official_cocktail_no }.jpg" />
					</div>
					</li>
					<li>
					<div class="card_content">
						<div class="card_title">
							<h3>${o.official_cocktail_name }</h3>
						</div>
						<div class="card_desc">
							<p>${o.official_cocktail_detail }</p>
						</div>
						<div class="card_info">
							<div>
								<i class="material-icons">thumb_up</i>
								${o.official_cocktail_vote }
							</div>
							<div>
								<a class="card_link"
									href="/official/view?official_no=${o.official_cocktail_no }">Read
									More...</a>
							</div>
						</div>
					</div>
					</li>
				</ul>
			</c:forEach>
		</div>
	</div>

	<!-- 카드보드형태 -->
	<div class="cards" id="card">

		<div
			style="margin: 0 auto; margin-top: 100px; width: 45%; text-align: center;">
			<h3>커스텀 칵테일</h3>
			<hr>
		</div>

		<c:forEach var="c" items="${list2 }">
			<ul style="margin: 0 auto; width: 760px; height: 350px; margin-bottom: 50px;">
				<li>
					<div class="card_image" id="card_thumbnail${c.custom_board_no })">
						<!-- 첨부파일이 이미지가 아니거나 없을 경우 -->
						<img width="350px" height="350px"
							src="/upload/${c.custom_board_attachment }"
							onerror="this.src='/resources/img/noimage_cup.jpg'" />
					</div>
				</li>
				<li>
					<div class="card_content">
						<div class="card_title">
							<h3>${c.custom_board_title }</h3>
						</div>
						<div class="card_desc">
							<p>${c.custom_board_content }</p>
						</div>
						<div class="card_info">
							<div>
								<i class="material-icons">thumb_up</i> ${c.custom_board_vote } <a>by
									${c.user_nickname }</a>
							</div>
							<div style="text-align: center;">
								<a class="card_link"
									href="/custom/view?custom_no=${c.custom_board_no }">Read
									More...</a>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</c:forEach>
	</div>



	<div>
		<div style="margin: auto 5%; margin-bottom: 100px;">

			<div
				style="margin: 0 auto; margin-top: 100px; width: 45%; text-align: center;">
				<h3>자유게시판</h3>
				<hr>
			</div>

			<c:if test="not empty ${boardList }">
				<table class="table table-striped">
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>

					<c:forEach items="${boardList }" var="board">
						<tr>
							<td>${board.free_board_no }</td>
							<td><a href="/free/view?freeboardno=${board.free_board_no }">
									${board.free_board_title } </a></td>
							<td>${board.user_nickname}</td>
							<td>${board.free_board_hit }</td>
							<td>${board.free_board_date }</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>

<footer>
	<div class="footer_logo">
		<img width=100px; src='/resources/img/header_logo2.png' />
	</div>
	<div class="footer_content">
		COMPANY. 오늘 뭐 마시지 <br> TEAM. 강건, 김준홍, 박정서, 이다영, 조여진, 홍의표<br>
		COPYRIGHT 2021. 오늘 뭐 마시지. ALL RIGHTS RESERVED.
	</div>
</footer>

</html>