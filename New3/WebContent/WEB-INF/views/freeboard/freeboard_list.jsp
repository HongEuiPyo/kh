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
/*     position: absolute; */
/*     left: 0; */
/*     bottom: 0; */
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



<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnwrite").click(function() {
		if( '${login }' == false ){
			alert("로그인을 해야지 글을 등록할 수 있습니다");
			return false;
		}
		
		location.href="/free/write";
		
	});
	
	$("#btnSearch").click(function(){
		if( $("#search").val() == "" || $("#search").val() == null){
			alert("검색어를 입력하세요");
			location.href="/free/list";
			return false;
		}
		
		location.href="/free/search?type="+$("#type").val() + "&search="+$("#search").val();
		
	});
});
</script>

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

<div style="width:100%; height: 100%; position: relative;">
<div style="margin: 0 auto; width: 60%;">
<h1>자유게시판</h1>
<hr>
</div>


<div style="margin: 0 auto; width: 60%;">
<table class="table table-striped table-hover">
<tr>
	<th style="width:6%; text-align:center;">글번호</th>
	<th style="width:55%;">제목</th>
	<th style="width:12%;">작성자</th>
	<th style="width:6%;">조회수</th>
	<th style="width:13%;">작성일</th>
</tr>

<c:forEach items="${boardList }" var="board">
<tr>
	<td>${board.free_board_no }</td>
	<td>
		<a href="/free/view?type=free&freeboardno=${board.free_board_no }">
		${board.free_board_title }
		</a>
	</td>
	<td>${board.user_nickname}</td>
	<td>${board.free_board_hit }</td>
	<td>${board.free_board_date }</td>
</tr>
</c:forEach>

</table>



<button id="btnwrite" class="btn btn-info float-right" style="float:right">글 쓰기</button>

<c:import url="/WEB-INF/views/layout/free_board_list.jsp" />

<form action="<%=request.getContextPath() %>/free/search" method="get">
<div style="text-align:center">
<select id="type" name="type">
	<option value="title">제목</option>
	<option value="content">본문 내용</option>
	<option value="writer">작성자</option>
</select>
<input type="text" id="search" name="search"/>
<button type="submit" class="btn btn-default btn-sm" id="btnSearch">검색</button>
</div>
</form>

</div>
</div>
</body>
<c:import url="/WEB-INF/views/layout/footer.jsp" />