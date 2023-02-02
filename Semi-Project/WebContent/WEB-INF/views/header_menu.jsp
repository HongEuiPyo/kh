<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>오늘 뭐 마시지 - </title>

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
	    background-image: url('/resources/img/cheers02.jpg');
        background-repeat: no-repeat;
/*         background-size: 1500px 900px; */
/* 		background-image: url("/resources/img/cocktail_bg02.jpg") no-repeat; */
/* 		background: brown;  */
 		width:100%;
 		height:600px;
 	} 
 	
.header {
		top: 0;
 		display:flex;
 		width:100%;
 		margin: auto;
 		height: 86px;
 		background: rgba(0,0,0,0.6);
 		position: fixed;
 	}

.header_logo {
	margin-top: -10px;
	margin-left: 95px;
	position: absolute;
}

.login {
	color: #fff;
}

.login > form > button {
	color: #fff;
	background: blue;
	border: none;
	font-size: 16px;
	margin-top: 25px;
	margin-left: 110px;
	padding: 5px;
	cursor: pointer;
}

.join {
	color: #fff;
}

.join > button {
	color: #fff;
	background: red;
	border: none;
	font-size: 16px;
	margin-top: 25px;
	padding: 5px;
	cursor: pointer;
}
 
 .nav{
 	display: flex;
 	justify-content: flex-end;
 	line-height: 86px;
 	width: calc(1280px - 400px );
/*  	margin-right: - 84px; */
	padding-left: 0;
 	margin-left: 290px;
/*  	position: relative; */
 }	
 
 .nav > li:not(:first-child) {
 	margin-left: 84px;
 }
 
 .nav > li:first-child {
 }
 
 .nav > li > a {
 	 	color: #fff;
 }
 
 .nav > li > a:hover {
 	color: orange;
 }
 
 .content_area {
 	width: 1280px;
 	height: 780px;
/*   	margin-top: -200px; */
 	background: white;
 	margin: auto;
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
				<div class="header_logo">
					<a href="/main">
						<img  width=100px; src='/resources/img/header_logo2.png'/>
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
		</div>
	</div>
</body>

<footer>
	<div class="footer_logo">
		<img  width=100px; src='/resources/img/header_logo2.png'/>
	</div>
	<div>
		CEO. 오늘 뭐 마시지 <br>	
		Coworker. 강건, 김준홍, 박정서, 이다영, 조여진, 홍의표<br>
		COPYRIGHT 2021. 오늘 뭐 마시지. ALL RIGHTS RESERVED.
	</div>
</footer>

</html>

























