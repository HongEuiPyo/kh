<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>    
<link rel="stylesheet" type="text/css" href="/resources/css/cards.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
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
<br><br><br><br><br>

<!-- 검색창 -->
<div class="search-bar">
	<form name="searchForm" action="/official/list" method="get">
	<select id="category" name="category" value="${category }">
   		<option value="all">전체</option>
   		<option value="name">이름</option>
   		<option value="detail">내용</option>
   		<option value="ingred">재료</option>
  	</select>
	<input type="text" name="search" value="${search }" autocomplete="off" 
	id="search" placeholder="검색어를 입력하세요">
	<input type="submit" id="btnSearch" value="찾기">
	</form>
</div>


<div class="main">

<!-- 카드보드형태 -->
<div class="cards" id="card">
	<c:forEach var="o" items="${list }">
	<div class="card">
	<div class="card_image">
		<img src="/resources/img/official_cocktail/official_cocktail_${o.official_cocktail_no }.jpg" />
	</div>
	<div class="card_title">
		<c:set var="cocktail_title" value="${fn:split(o.official_cocktail_name,',')}" />
		<a class="card_title_eng">${ cocktail_title[0]}</a><br>
		<a class="card_title_kor">${ cocktail_title[1]}</a>
	</div>
	<div class="card_desc">
		<p>${o.official_cocktail_detail }</p>
	</div>
	<div class="card_info">
		<div class="card_viewcount">
			<span class="material-icons">visibility</span><a style="margin-left:5px;">${o.official_cocktail_hit }</a>
		</div>
		<div>
			<a class="card_link" href="/official/view?official_no=${o.official_cocktail_no }">Read More...</a>
		</div>
	</div>
	</div>
	</c:forEach>
</div>
</div>
<div class="space" style="height:20px;display:inline-block;"></div>
<style>
footer {
	position: sticky !important;
}
</style>
<c:import url="/WEB-INF/views/layout/official_paging.jsp" />
<c:import url="/WEB-INF/views/layout/footer.jsp" />    