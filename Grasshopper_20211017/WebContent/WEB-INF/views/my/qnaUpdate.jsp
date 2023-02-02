<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<!-- <form>태그의 submit을 수행하면 editor에 작성한 내용을 <textarea>에 반영 -->
<script type="text/javascript">
	function submitContents(elClickedObj) {

		//에디터의 내용을 #content에 반영한다
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

		try {
			// <form>태그의 submit 수행
			elClickedObj.form.submit();
		} catch (e) {
		}

	}
</script>

<script type="text/javascript">
	$(document).ready(function() {

		//수정버튼 동작
		$("#btnUpdate").click(function() {

			//스마트 에디터의 내용을 <textarea>에 적용하는 함수를 호출한다
			submitContents($("#btnUpdate"))

			//<form> submit
			$("form").submit();
		});

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});

			//파일이 없을 경우
			if(${not empty boardFile }) {
				$("#beforeFile").show();
				$("#afterFile").hide();
			}

			//파일이 있을 경우
			if(${empty boardFile }) {
				$("#beforeFile").hide();
				$("#afterFile").show();
			}

			//파일 삭제 버튼(X) 처리
			$("#delFile").click(function() {
				$("#beforeFile").toggle();
				$("#afterFile").toggle();
			})

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

				<h3 style="margin-top: 100px;">문의 내역 수정</h3>
				<hr>

				<div>
					<form action="/qna/update" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="boardno"
							value="${updateBoard.qna_board_no }" />

						<table class="table table-bordered">
							<tr>
								<td class="info">닉네임</td>
								<td>${user_info.user_nickname }</td>
							</tr>
							<tr>
								<td class="info">제목</td>
								<td><input type="text" name="title" style="width: 100%"
									value="${updateBoard.qna_board_title }" /></td>
							</tr>
							<tr>
								<td class="info" colspan="2">본문</td>
							</tr>
							<tr>
								<td colspan="2"><textarea id="content" name="content">${updateBoard.qna_board_content }</textarea></td>
							</tr>
						</table>

						<!-- 첨부파일 -->
						<div>
							<div id="beforeFile">
								기존 첨부파일: <a href="/upload/${boardFile.stored_file_name }"
									download="${boardFile.original_file_name }">${boardFile.original_file_name }</a>
								<span id="delFile"
									style="color: red; font-weight: bold; cursor: pointer;">X</span>
							</div>

							<div id="afterFile">
								새 첨부파일: <input type="file" name="file" />
							</div>
						</div>

						<br>
					</form>
				</div>

				<div class="text-center">
					<button type="button" id="btnUpdate" class="btn btn-info">수정</button>
					<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
				</div>

				<!-- .container -->
			</div>


			<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "content", //에디터가 적용될 <textarea>의 id를 입력
			sSkinURI : "/resources/se2/SmartEditor2Skin.html",
			fCreator : "createSEditor2"
		})
	</script>


			<c:import url="/WEB-INF/views/layout/footer.jsp" />