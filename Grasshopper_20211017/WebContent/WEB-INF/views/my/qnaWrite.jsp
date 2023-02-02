<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 마시지 -</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/resources/css/headerfooter.css">

<!-- 스마트에디터 2 -->
<script type="text/javascript"
	src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

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


<script type="text/javascript">
	//<form>태그에 submit이 수행되면 스마트에디터에 작성한 내용을 <textarea>에 반영한다
	function submitContents(elClickedObj) {

		//에디터의 내용을 #content에 반영해준다
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

		try {
			//<form>태그의 submit을 수행한다
			elClickedObj.form.submit();
		} catch (e) {
		}
	}
</script>


<script type="text/javascript">
	$(document).ready(function() {

		//작성버튼 동작
		$("#btnWrite").click(function() {

			//스마트 에디터의 내용을 <textarea>에 적용하는 함수를 호출한다
			submitContents($("#btnWrite"))

			$("form").submit();
		});

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});

	});
</script>

<style type="text/css">
#content {
	/* 	width: 100%; */
	width: 98%;
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

				<h1 style="margin-top: 100px;">문의합니다</h1>
				<hr>

				<div>
					<form action="/qna/write" method="post"
						enctype="multipart/form-data">

						<table class="table table-bordered">
							<tr>
								<td class="info">닉네임</td>
								<td>${user_info.user_nickname }</td>
							</tr>
							<tr>
								<td class="info">제목</td>
								<td><input type="text" name="title" style="width: 100%" /></td>
							</tr>
							<tr>
								<td class="info" colspan="2">문의 내용</td>
							</tr>
							<tr>
								<td colspan="2"><textarea id="content" name="content"></textarea></td>
							</tr>
						</table>

						첨부파일 <input type="file" name="file" />

					</form>
				</div>

				<div class="text-center">
					<button type="button" id="btnWrite" class="btn btn-info">작성</button>
					<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
				</div>

				<!-- .container -->
			</div>

			<!-- <textarea>태그에 스마트에디터2 적용하는 스크립트 -->
			<script type="text/javascript">
				var oEditors = [];
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : oEditors,
					elPlaceHolder : "content",
					sSkinURI : "/resources/se2/SmartEditor2Skin.html",
					fCreator : "createSEditor2"
				});
			</script>


			<c:import url="/WEB-INF/views/layout/footer.jsp" />