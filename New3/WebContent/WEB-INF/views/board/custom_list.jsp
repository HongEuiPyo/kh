<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>    
<link rel="stylesheet" type="text/css" href="/resources/css/cards.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      
<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnwrite").click(function() {
		if( '${login }' == false ){
			alert("로그인을 해야지 글을 등록할 수 있습니다");
			return;
		}
		location.href="/custom/write";
		
	});
});
</script>     
</head>

<style>
/* .nav>li>a { */
/*     position: static; */
/*     display: flex; */
/*     padding: 0; */
/*     font-size: 16px; */
/* } */
</style>
<body>

	<div class="wrap">
		<div class="intro_bg2" style="width: 100%; height: 500px; background-position: top; background-positoin: center; background-repeat: no-repeat; background-image: url('/resources/img/cocktailbar.jpg');">
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
<body>
<br><br><br>
<button id="btnwrite" class="btn viewButton" style="">글 쓰기</button>
<br><br>
<!-- 검색창 -->
<div class="search-bar">
	<form name="searchForm" action="/custom/list" method="get">
	<select id="category" name="category" value="${category }">
   		<option value="all">전체</option>
   		<option value="title">제목</option>
   		<option value="detail">내용</option>
   		<option value="nickname">글쓴이</option>
  	</select>
	<input type="text" name="search" value="${search }" autocomplete="off" 
	id="search" onkeyup="searchFunction()" placeholder="검색어를 입력하세요">
	<input type="submit" id="btnSearch" value="찾기">
	</form>
</div>


<div class="main">

<!-- 카드보드형태 -->
<div class="cards" id="card">
	<c:forEach var="c" items="${list }">
	<div class="card">
	<div class="card_image" id="card_thumbnail${c.custom_board_no })">
		<img src="/upload/${c.custom_board_attachment }" onerror="this.src='/resources/img/noimage_cup.jpg'" />
	</div>
	<div class="card_title">
		<h3>${c.custom_board_title }</h3>
		<h5>by ${c.user_nickname }</h5>
	</div>
	<div class="card_desc">
		<p>${c.custom_board_content }</p>
	</div>
	<div class="card_info">
		<div class="card_viewcount">
			<span class="material-icons">visibility</span><a style="margin-left:5px;">${c.custom_board_hit }</a>
		</div>
		<div>
			<a class="card_link" href="/custom/view?custom_no=${c.custom_board_no }">Read More...</a>
		</div>
	</div>
	</div>
	</c:forEach>
</div>
</div>
<style>
footer {
	position: sticky !important;
}
</style>
</body>

<c:import url="/WEB-INF/views/layout/custom_paging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" /> 