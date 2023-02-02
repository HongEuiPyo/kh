<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 마시지 -</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/resources/css/headerfooter.css">

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 부트스트랩 3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
.popupOpen {
	cursor: pointer;
}

.popupWrap {
	z-index: 99999;
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 0;
	background-color: rgba(0, 0, 0, 0.6);
}

.popupWrap .popup {
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -200px;
	margin-top: -200px;
	width: 400px;
	height: 400px;
	background-color: #fff;
	border-radius: 10px;
	padding: 0 10px;
}

.popupWrap div textarea {
	width: 100%;
	padding: 0;
}

.popupWrap div .title {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.popupWrap div .title p {
	line-height: 50px;
	margin: 0;
}

.hide {
	display: none;
}

.btnWrap {
	text-align: right;
}

.btnWrap button {
	border-radius: 5px;
	background-color: rgb(104, 122, 204);
	color: #fff;
	border: none;
	padding: 10px;
}
</style>
</head>

<body>
	<div class="wrap">
		<div class="intro_bg">
			<div class="header">
				<div class="header_logo">
					<a href="/main"> <img width=100px;
						src='/resources/img/header_logo2.png' />
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

			<div class="container">

				<h1 style="margin-top: 100px;">문의 상세 보기</h1>
				<hr>

				<table class="table table-bordered">
					<tr>
						<td class="info">닉네임</td>
						<td colspan="3" class="popupOpen">${user_info.user_nickname }</td>
					</tr>


					<tr>
						<td class="info">글번호</td>
						<td colspan="3">${viewBoard.qna_board_no }</td>
					</tr>

					<tr>
						<td class="info">제목</td>
						<td colspan="3">${viewBoard.qna_board_title }</td>
					</tr>

					<!-- <tr> -->
					<%-- <td class="info">이메일</td><td>${viewBoard.userid }</td> --%>
					<%-- <td class="info">닉네임</td><td>${nick }</td> --%>
					<!-- </tr> -->


					<tr>
						<td class="info" colspan="4">본문</td>
					</tr>

					<tr>
						<td colspan="4" style="height:350px" >${viewBoard.qna_board_content }</td>
					</tr>

					<tr>
						<td class="info">작성일</td>
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

				<div class="text-center">
					<button id="btnList" class="btn btn-primary">목록</button>
					<button id="btnUpdate" class="btn btn-info">수정</button>
					<button id="btnDelete" class="btn btn-danger">삭제</button>
				</div>


				<div>

					<div class="popupWrap hide">
						<form action="/message/test" method="post">
						<input type="hidden" name="boardno" value="${viewBoard.qna_board_no }" />
							<div class="popup">
								<div class="title">
									<p>${user_info.user_nickname }</p>
									<span class="close">❌</span>
								</div>
								<textarea name="message" id="message" cols="30" rows="10"></textarea>
								<div class="btnWrap">
									<button>보내기</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				$(document).ready(function() {
				//목록버튼 동작
				$("#btnList").click(function() {
					$(location).attr("href", "/qna/list");
				});

				//수정버튼 동작
				$("#btnUpdate").click(function() {
					$(location).attr("href","/qna/update?boardno=${viewBoard.qna_board_no }");
				});

				//삭제버튼 동작
				$("#btnDelete").click(function() {
					if (confirm("게시글을 삭제하시겠습니까?")) {
						$(location).attr("href","/qna/delete?boardno=${viewBoard.qna_board_no }");
					}
				});
			});
			</script>
			<script>
				$('.popupOpen').on('click', function() {
					$('.popupWrap').removeClass('hide');
				});
				$('.close').on('click', function() {
					$(this).parents('.popupWrap').addClass('hide');
					$(this).parents('.popup').children('textarea').val('');
				});

				$(".btnWrap").click(function() {
					$(location).attr("href","/message/test");
				});
			</script>


			<c:import url="/WEB-INF/views/layout/footer.jsp" />