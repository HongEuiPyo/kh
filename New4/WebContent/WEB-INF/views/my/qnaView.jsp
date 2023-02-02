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

		<div class="content">
			<!-- 여기가 메뉴 영역이ㅇ여요 -->
			<%@ include file="../layout/mypagenav.jsp"%>
			<div class="contentAreaWrap">
				<div class="container">

					<h1>
						<strong>문의 상세 보기</strong>
					</h1>
					<hr>

					<table class="table table-bordered">
						<tr>
							<td class="">닉네임</td>
							<td colspan="3">${user_info.user_nickname }</td>
						</tr>


						<tr>
							<td class="">글번호</td>
							<td colspan="3">${viewBoard.qna_board_no }</td>
						</tr>

						<tr>
							<td class="">제목</td>
							<td colspan="3">${viewBoard.qna_board_title }</td>
						</tr>

						<!-- <tr> -->
						<%-- <td class="info">이메일</td><td>${viewBoard.userid }</td> --%>
						<%-- <td class="info">닉네임</td><td>${nick }</td> --%>
						<!-- </tr> -->


						<tr>
							<td class="" colspan="4">본문</td>
						</tr>

						<tr>
							<td colspan="4" style="height: 350px">${viewBoard.qna_board_content }</td>
						</tr>

						<tr>
							<td class="">작성일</td>
							<td>${viewBoard.qna_board_date }</td>
						</tr>

					</table>

					<!-- 첨부파일 -->
					<div>
						<c:if test="${not empty boardFile }">
							<a href="/upload/${boardFile.stored_file_name }"
								download="${boardFile.original_file_name }">${boardFile.original_file_name }</a>
						</c:if>
					</div>


				</div>

				<c:forEach items="${qna_board_reply}" var="qna_board_reply">
					<c:if
						test="${qna_board_reply.qna_board_no eq viewBoard.qna_board_no }">
						<div class="container">
							<div class="card"
								style="background-color: #ededed; margin-top: 40px;">
								<div class="card-body" style="height: 200px; border: 1px solid #ccc;" >
									<p class="h5">
										<h3>문의 사항 답변입니다.</h3>
									</p>
									<h4>
										${qna_board_reply.qna_reply_content }
									</h4>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>

				<c:if test="${user_info.user_email eq 'projectkhwork@gmail.com'  }">
					<div class="container replyWrite">
						<hr>
						<form class="form-horizontal" action="/qna/reply" method="post">
							<div class="form-group">
								<input type="hidden" name="board_no"
									value="${viewBoard.qna_board_no }">
								<textarea class="form-control" rows="5" id="commentContent"
									name="commentContent"></textarea>
								<br>
								<button type="submit" class="btn pull-right">등록</button>
							</div>
						</form>
						<hr>
					</div>
				</c:if>
				<div class="text-center" style="margin-bottom: 150px;">
					<button id="btnList" class="btn btn-primary">목록</button>
					<button id="btnUpdate" class="btn btn-info">수정</button>
					<button id="btnDelete" class="btn btn-danger">삭제</button>
				</div>
			</div>
			<script type="text/javascript">
				$(document)
						.ready(
								function() {
									//목록버튼 동작
									$("#btnList").click(function() {
										$(location).attr("href", "/qna/list");
									});

									//수정버튼 동작
									$("#btnUpdate")
											.click(
													function() {
														$(location)
																.attr("href",
																		"/qna/update?boardno=${viewBoard.qna_board_no }");
													});

									//삭제버튼 동작
									$("#btnDelete")
											.click(
													function() {
														if (confirm("게시글을 삭제하시겠습니까?")) {
															$(location)
																	.attr(
																			"href",
																			"/qna/delete?boardno=${viewBoard.qna_board_no }");
														}
													});

									$(document).ready(function() {
										//페이지 첫 접속 시 입력창으로 포커스 이동
										$("input").eq(0).focus();
									});

								});
			</script>
		</div>
	</div>
	<c:import url="/WEB-INF/views/layout/footer.jsp" />