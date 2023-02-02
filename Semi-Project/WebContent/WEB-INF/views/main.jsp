<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �� ������</title>
 
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
					<span>�˻�</span>
					</form>
				</div>
				<ul class="nav">
					<li><a href="/main">Ĭ���� �˻�</a></li>
					<li><a href="/main">Ĭ���� ����</a></li>
					<li><a href="/main">Ŀ�´�Ƽ �Խ���</a></li>
					<li><a href="/main">����</a></li>
					<li><a href="/main">���ǰԽ���</a></li>
				</ul>
			</div>
			<div class="intro_text">
			<h1>�� ģ���� �߾��� �ǻ츮�� Ĭ����</h1><br>
			<h4 class="contents1">Ĭ���� �̸��� ������ ģ��, ��ģ����� �ǹ��̴�.</h4>
			<h4 class="contents1">�Ƹ޸�ĭ Ĭ�����̱� ������ ���� ����Ű�� ����ϴ� ���� ����.</h4>
			<h4 class="contents1">���� ����Ű�� ������ ĳ����� ����Ű�� ����Ѵ�.</h4>
			<h4 class="contents1">������ ���ô� ���丮Ƽ�� Ĭ���Ϸμ� �����ϴ�.</h4>
			</div>
		</div>
		</div>
		
		<ul class="amount">
			<li>
				<div>
					<div class="contents1">�з�</div>
					<div class="result">Ĭ����(Cocktail)</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents1">���̽�</div>
					<div class="result">Whisky</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents1">��</div>
					<div class="result">�ణ �ܸ�</div>
				</div>
			</li>
			<li>
				<div>
					<div class="contents1">���ڿõ���</div>
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
					<div class="contents_bold">Ĭ���� �˻�</div>
					<div class="contents3"></div>
					<div class="more">
					MORE
					</div>
				</li>
				<li>
					<div class="icon_img">
						<img src="image/icon0.svg">
					</div>
					<div class="contents_bold">Ĭ���� ����</div>
					<div class="contents3"></div>
					<div class="more">
					MORE
					</div>
				</li>
				<li>
					<div class="icon_img">
						<img src="image/icon0.svg">
					</div>
					<div class="contents_bold">����</div>
					<div class="contents3"></div>
					<div class="more">
					MORE
					</div>
				</li>
			</ul>
		</div>
		
		<div class="main_text1">
			<h1>ȭ���� ������</h1>
			<div class="contents1">�Ϲ����� ���� ������ ȭ���� Ĭ���� ������</div>
			<div class="service">
				<div class="food_photo">
					<img src="image/food.png"/>
				</div>
				<div class="contents3">
					<h2>�ع� (June Bug)</h2>
					'6���� ����'��� �ǹ̷�, �ʷ��� �̱׷��� ������ �׾߸��� ���������� �����Ų��.
					���, �ٳ���, ���ڳ�, ���ξ���, ���� 5���� ���� ���� ������ ���� ������ Ĭ�����̴�.
				</div>
			</div>
			
			<div class="main_text2">
				<ul>
					<li>
						<div><h1>CONTACT</h1></div>
						<div>�츮���� ��Ʈ�ʽ��� ��û�ϰų�, ���� �Ǿ��ּ���</div>
						<div class="more2">
							�� �˾ƺ���
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
		CEO. ���� �� ������ <br>	
		Coworker. ����, ����ȫ, ������, �̴ٿ�, ������, ȫ��ǥ<br>
		COPYRIGHT 2021. ���� �� ������. ALL RIGHTS RESERVED.
	</div>
</footer>

</html>















