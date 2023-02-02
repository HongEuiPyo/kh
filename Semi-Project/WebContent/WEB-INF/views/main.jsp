<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>오늘 뭐 마시지</title>
 
 <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
 
<style>
	*{
 		font-family: 'Noto Sans KR', sans-serif;
 		list-style: none;
 		text-decoration: none;
 		border-collapse: collapse;
 		margin: 0px;
 		padding: 0px;
 		color: #000;
 	}
 	
 h1 {
 	font-size: 48px;
 	font-weight: 100;
 }
 
 .contents1{
 	font-size: 20px;
 	font-weight: lighter;
 }
 
 .contents3{
 	font-size: 14px;
 	font-weight: 100;
 }
 
 .contents_bold{
 	font-size: 18px;
 	font-weight: bold;
 }
 
 
 
 .result{
 	font-size: 24px;
 }
 	
 	.intro_bg {
 		background-image: url ("/WEB-INF/resources/img/cocktail_bg02.jpg") no-repeat;
/*  		background: brown; */
 		width:100%;
 		height:718px;
 	}
 	
.header {
 		display:flex;
 		width:1280px;
 		margin: auto;
 		height: 86px;
 }
 	
 .search_area{
 	width: 300px;
 	height: 40px;
 	background: rgba(0,0,0,0.5);
 	border-radius: 5;
 	margin-top: 24px;
 }
 
 .search_area > form > input{
 	border: none;
 	width: 250px;
 	height: 40px;
 	background: rgba(0,0,0,0.0);
 	color: #fff;
 	padding-left: 10px;
 }
 
 .search_area > form > span{
 	width: 50px;
 	color: #fff;
 	font-weight: bold;
 	cursor: pointer;
 }
 
 .nav{
 	display: flex;
 	justify-content: flex-end;
 	line-height: 86px;
 	width: calc(1280px - 300px );
 }	
 
 .nav > li{
 	margin-left:84px;
 }
 
 .nav > li > a {
 	 	color: #fff;
 }
 
 .amount{
 	position: relative;
 	top: -66px;
 	display: flex;
 	width:1280px;
 	background: #fff;
 	margin: auto;
 	box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
 }
 
 .amount > li{
 	flex: 1;
 	height: 132px;
 }
 
 .amount > li > div {
 	text-align: center;
 	margin-top: 37px;
 	height: 57px;
 }
 
 .amount > li:not(:last-child) > div{
 	border-right: 1px solid #E1E1E1;
 }
 
 .intro_text{
 	width:100%;
 	margin: 231px auto 231px auto;
 	color: red;
 	text-align: center;
 }
 
 .intro_text > h1,
 .intro_text > h4{
 	color: #fff;
 }
 	
/* main_text0 */

.main_text0{
	width: 100%;
	height: 601px;
	margin-top: -132px;
	background: #f1f2f3;
} 	

.main_text0 > h1 {
	padding-top: 116px;
	text-align: center;
}
 	
.main_text0 > .contents {
	text-align: center;
}

.icons{
	display: flex;
	width:1280px;
	margin: auto;
}

.icons > li {
	flex: 1;
	background: white;
	margin-top: 49px;
	height: 302px;
	text-align: center;
}

.icons > li > .icon_img {
	margin-top:18px;
}

.icons > li:not(:last-child) {
	margin-right: 20px;
}

.icons contents 3{
	width: 240px;
	margin: auto;
	letter-spacing: -1px;
}

.more{
	width: 180px;
	height: 30px;
	background: #2F7AF4;
	color: white;
	font-size: 12px;
	line-height: 30px;
	margin: 25px auto;
	cursor: pointer;
}

.main_text1 {
	width:100%;
}

.main_text1 > h1 {
	padding-top: 50px;
	text-align: center;
}

.main_text1 > .contents1 {
	text-align: center;
}

.service{
	width:1280px;
	dispaly:flex;
	margin: 49px auto;
	height:427px;
	background: skyblue;
}

.service > .contents3 {
	padding: 20px;
}
 
.service > .contents3 > h2{
	margin-bottom: 27px;
} 

.main_text2 {
	width:100%;
	height: 418px;
/* 	background-image: url("image/contact.png"); */
	background: orange;
}

.main_text2 > ul{
	display:flex;
	padding-top: 138px;
}

.main_text2 > ul > li {
	flex:1;
	text-align: center;
}

.main_text2 > ul > li > div > h1,
.main_text2 > ul > li > div {
	color: #fff;
}

.more2 {
	width:220px;
	height:40px;
	border: 1px solid #fff;
	line-height: 40px;
	cursor: pointer;
	margin: 16px auto;	
}

footer {
	display: flex;
	background: #1f1f1f;
	padding: 30px;
}

footer > div:first-child{
	flex: 3;
	text-align: center;
	color: #fff;
}

footer > div:last-child {
	flex: 9;
	color: #fff;
}
</style>

</head>
<body>
	<div class="wrap">
		<div class="intro_bg">
			<div class="header">
				<div class="search_area">
					<form>
					<input type="search" placeholder="search"/>
					<span>검색</span>
					</form>
				</div>
				<ul class="nav">
					<li><a href="/main">칵테일 검색</a></li>
					<li><a href="/main">칵테일 제작</a></li>
					<li><a href="/main">커뮤니티 게시판</a></li>
					<li><a href="/main">쇼핑</a></li>
					<li><a href="/main">문의게시판</a></li>
				</ul>
			</div>
			<div class="intro_text">
			<h1>옛 친구와 추억을 되살리는 칵테일</h1><br>
			<h4 class="contents1">칵테일 이름은 오래된 친구, 옛친구라는 의미이다.</h4>
			<h4 class="contents1">아메리칸 칵테일이기 때문에 라이 위스키를 사용하는 것이 좋다.</h4>
			<h4 class="contents1">라이 위스키가 없으면 캐나디안 위스키로 대용한다.</h4>
			<h4 class="contents1">식전에 마시는 아페리티프 칵테일로서 적합하다.</h4>
			</div>
		</div>
		</div>
		
		<ul class="amount">
			<li>
				<div>
					<div class="contents1">분류</div>
					<div class="result">칵테일(Cocktail)</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents1">베이스</div>
					<div class="result">Whisky</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents1">맛</div>
					<div class="result">약간 단맛</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents1">알코올도수</div>
					<div class="result">27</div>
				</div>
			</li>			
		</ul>
			
		<div class="main_text0">
			<h1>ABOUT</h1>
			<div class="contents"></div>
			
			<ul class="icons">
				<li>
					<div class="icon_img">
						<img src="image/icon0.svg">
					</div>
					<div class="contents_bold">칵테일 검색</div>
					<div class="contents3"></div>
					<div class="more">
					MORE
					</div>
				</li>
				<li>
					<div class="icon_img">
						<img src="image/icon0.svg">
					</div>
					<div class="contents_bold">칵테일 제작</div>
					<div class="contents3"></div>
					<div class="more">
					MORE
					</div>
				</li>
				<li>
					<div class="icon_img">
						<img src="image/icon0.svg">
					</div>
					<div class="contents_bold">쇼핑</div>
					<div class="contents3"></div>
					<div class="more">
					MORE
					</div>
				</li>
			</ul>
		</div>
		
		<div class="main_text1">
			<h1>화제의 레시피</h1>
			<div class="contents1">일반인이 직접 제작한 화제의 칵테일 재조법</div>
			<div class="service">
				<div class="food_photo">
					<img src="image/food.png"/>
				</div>
				<div class="contents3">
					<h2>준벅 (June Bug)</h2>
					'6월의 벌레'라는 의미로, 초록의 싱그러운 색깔이 그야말로 여름벌레를 연상시킨다.
					멜론, 바나나, 코코넛, 파인애플, 레몬 5가지 맛이 나는 도수가 낮은 달콤한 칵테일이다.
				</div>
			</div>
			
			<div class="main_text2">
				<ul>
					<li>
						<div><h1>CONTACT</h1></div>
						<div>우리에게 파트너십을 신청하거나, 고객이 되어주세요</div>
						<div class="more2">
							더 알아보기
						</div>
					</li>
					<li></li>
				</ul>
			</div>
		</div>
</body>

<footer>
	<div>
		LOGO
	</div>
	<div>
		CEO. 오늘 뭐 마시지 <br>	
		Coworker. 강건, 김준홍, 박정서, 이다영, 조여진, 홍의표<br>
		COPYRIGHT 2021. 오늘 뭐 마시지. ALL RIGHTS RESERVED.
	</div>
</footer>

</html>















