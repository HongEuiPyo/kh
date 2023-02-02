<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 마시지?</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 구글 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	color: #000;
}
html {
    position: relative;
    min-height: 100%;
    margin: 0;
}
body {

    min-height: 100%;

}
footer {
    background: #1f1f1f;
    left: 0;
    bottom: 0;
    width: 100%;
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    padding: 15px 0;
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
	margin-left: 50px;
}

.nav>li:first-child {
	
}

.nav>li>a {
	color: #fff;
	text-decoration: none !important;
	font-size: 16px;
}

.nav>li>a:hover {
	color: orange;
	text-decoration: none;
	background: none !important;
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
	margin-left: 270px;
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
.width1 {
	width=""
}
</style>


<script type="text/javascript" src="/resources/script/media_query.js"
	defer></script>

</head>
