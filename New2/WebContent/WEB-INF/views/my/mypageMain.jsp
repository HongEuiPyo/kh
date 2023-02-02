<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:import url="/WEB-INF/views/layout/mypagehd.jsp" /> --%>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<link rel="stylesheet" type="text/css" href="/resources/css/mypage.css">
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
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

	<div style="min-height: 90vh;">
		<div class="nav1">
			<h1>
				<a href="/mypage/main"><strong>마이페이지</strong></a>
			</h1>
			<ul>
				<li><c:if test="${empty attachmentFile.profile_name }">
						<img src="/resources/img/기본프로필.jpg" />
					</c:if> <c:if test="${not empty attachmentFile.profile_name }">
						<img src="/upload/${attachmentFile.profile_name }" alt="프로필사진" />
					</c:if></li>
				<li><strong>${user_info.user_nickname }님, 환영합니다</strong></li>
			</ul>
		</div>

		<div class="content">
			<ul class="menu">
				<li>
					<h4>프로필 설정</h4>
					<p>
						<a href="/mypage/update">프로필 관리</a>
					</p>
				</li>
				<li>
					<h4>나의 활동</h4>
					<p>
						<a href="/mypage/board/list">내가 쓴 게시글</a>
					</p>
					<p>
						<a href="/mypage/reply/list">내가 쓴 댓글</a>
					</p>
				</li>
				<li>
					<h4>쪽지 확인</h4>
					<p>
						<a href="/mypage/sendmessage">보낸 쪽지 확인</a>
					</p>
					<p>
						<a href="/mypage/recmessage">받은 쪽지 확인</a>
					</p>
				</li>
				<li>
					<h4>나의 문의 내역</h4>
					<p>
						<a href="/qna/write">문의 하기</a>
					</p>
					<p>
						<a href="/qna/list">문의 내역</a>
					</p>
				</li>
				<li>
					<h4>
						<a href="/mypage/unregister">회원 탈퇴</a>
					</h4>
				</li>
				<!-- li 형식 반복 -->
			</ul>
			<div class="contentAreaWrap">
				<div class="profileWrap">

					<c:if test="${empty login or not login }">
						<img
							src="https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20201110_157%2F1604988552132g3niM_JPEG%2F6124385887958596_1519189238.jpg&type=sc960_832"
							alt="엘모" />
					</c:if>
					<c:if test="${not empty login and login }">
						<c:if test="${not empty attachmentFile.profile_name }">
							<img src="/upload/${attachmentFile.profile_name }" alt="프로필사진" />
						</c:if>
						<c:if test="${empty attachmentFile.profile_name }">
							<img src="/resources/img/기본프로필.jpg" />
						</c:if>
					</c:if>

					<p>
						<span><strong>${user_info.user_nickname }</strong></span>
					</p>
					<button type="button" class="btn btn-light"
						onclick='location.href="/mypage/update";'>내 정보 수정하기</button>
					<!-- 페이지 이동이면 <a><span>내 정보 수정하기</span></a> -->
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/layout/footer.jsp" />