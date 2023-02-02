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
							onclick='location.href="/member/join";'>회원가입</button>
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
						<a href="/mypage/update"><img src="/resources/img/기본프로필.jpg" /></a>
					</c:if> <c:if test="${not empty attachmentFile.profile_name }">
						<a href="/mypage/update"><img src="/upload/${attachmentFile.profile_name }" alt="프로필사진" /></a>
					</c:if></li>
				<li><strong>${user_info.user_nickname }님, 환영합니다</strong></li>
			</ul>
		</div>

		<div class="content" style="margin-bottom: 100px;">
			<!-- 여기가 메뉴 영역이ㅇ여요 -->
			<%@ include file="../layout/mypagenav.jsp"%>
			<div class="contentAreaWrap">
				<!-- ******************************
            
                페이지 별로 컨텐츠 내용 넣는 영역 ^^ 
                컨텐츠 넣는 영역이야~ 쪽지함이면 쪽지 리스트~ 문의하기면 문의하기 폼 영역 이런거
            
            ***********************************-->
				<div class="container" style="margin-bottom: 100px;">
					<h1>
						<strong>내가 쓴 댓글</strong>
					</h1>
					<hr>
					<h4 style="margin-top: 50px; margin-bottom: 30px;">자유게시판 댓글</h4>
					<table class="table table-hover table-condensed">
						<tr>
							<th>글번호</th>
							<th style="padding-left: 150px;">댓글내용</th>
							<th>작성일</th>
						</tr>
						<c:forEach items="${freeBoardReply }" var="freeReply">
							<tr>
								<td>${freeReply.free_board_no }</td>
								<td style="padding-left: 150px;"><a
									href="/free/view?freeboardno=${freeReply.free_board_no }"><span
										class="ellipsis2">${freeReply.free_reply_content }</span></a></td>
								<td>${freeReply.free_reply_date }</td>
							</tr>
						</c:forEach>
					</table>

					<h4 style="margin-top: 50px; margin-bottom: 30px;">커스텀게시판 댓글</h4>
					<table class="table table-hover table-condensed">
						<tr>
							<th>글번호</th>
							<th style="padding-left: 150px;">댓글내용</th>
							<th>작성일</th>
						</tr>
						<c:forEach items="${customReply }" var="customReply">
							<tr>
								<td>${customReply.custom_board_no }</td>
								<td style="padding-left: 150px;"><a
									href="/custom/view?custom_no=${customReply.custom_board_no }">
										<span class="ellipsis2">${customReply.custom_reply_content }</span>
								</a></td>
								<td>${customReply.custom_reply_date }</td>
							</tr>
						</c:forEach>
					</table>

					<h4 style="margin-top: 50px; margin-bottom: 30px;">오피셜게시판 댓글</h4>
					<table class="table table-hover table-condensed">
						<tr>
							<th>글번호</th>
							<th style="padding-left: 150px;">댓글내용</th>
							<th>작성일</th>
						</tr>
						<c:forEach items="${officialReply }" var="officialReply">
							<tr>
								<td>${officialReply.official_board_no }</td>
								<td style="padding-left: 150px;"><a
									href="/official/view?official_no=${officialReply.official_board_no }"><span
										class="ellipsis2">${officialReply.official_reply_content }</span></a></td>
								<td>${officialReply.official_reply_date }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/layout/footer.jsp" />