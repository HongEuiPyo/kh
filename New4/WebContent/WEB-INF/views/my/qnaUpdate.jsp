<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 스마트에디터 2 -->
<script type="text/javascript"
	src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<%-- <c:import url="/WEB-INF/views/layout/mypagehd.jsp" /> --%>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<link rel="stylesheet" type="text/css" href="/resources/css/mypage.css">
<style type="text/css">
#content {
	/* 	width: 100%; */
	width: 98%;
}

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


	<div class="container" style="margin-top: 100px; margin-bottom: 150px;">

		<div class="container" style="margin-top: 100px; margin-bottom: 150px;">

		<h1>문의 내역 수정</h1>
		<hr>

		<div>
			<form action="/qna/update" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="boardno"
					value="${updateBoard.qna_board_no }" />

				<table class="table table-bordered">
					<tr>
						<td class="">닉네임</td>
						<td>${user_info.user_nickname }</td>
					</tr>
					<tr>
						<td class="" id="title">제목</td>
						<td><input type="text" name="title" style="width: 100%"
							value="${updateBoard.qna_board_title }" /></td>
					</tr>
					<tr>
						<td class="" colspan="2">문의 내용</td>
					</tr>
					<tr>
						<td colspan="2"><textarea id="content" name="content"
								style="height: 300px;">${updateBoard.qna_board_content }</textarea></td>
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
			<button type="button" id="btnUpdate" class="btn btn-primary me-md-2">수정</button>
			<button type="button" id="btnCancel" class="btn btn-primary ml-1">취소</button>
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

		});
	</script>



	<c:import url="/WEB-INF/views/layout/footer.jsp" />