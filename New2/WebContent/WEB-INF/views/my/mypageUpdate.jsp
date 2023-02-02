<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:import url="/WEB-INF/views/layout/mypagehd.jsp" /> --%>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<link rel="stylesheet" type="text/css" href="/resources/css/mypage.css">

<style type="text/css">
.modifyInfo label {
	width: 100px;
}

.modifyInfo .inputWrap {
	width: calc(100% - 100px) !important;
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

	<h3 style="text-align: center; margin-top: 100px;">
		<strong>내 정보 수정하기</strong>
	</h3>
	<div style="display: flex; justify-content: center;">
		<form class="form-horizontal row justify-content-md-center m1"
			action="/mypage/update" method="post" enctype="multipart/form-data"
			id="form">
			<div style="min-width: 320px;"
				class="col-md-auto mt-2 mb-5 modifyInfo">
				<input type="hidden" name="user_no" value="${user_info.user_no }" />
				<div class="form-group">
					<label class="col-sm-2 control-label"><strong>Email</strong></label>
					<div class="col-md-8">
						<p class="form-control-static">${user_info.user_email }</p>
					</div>
				</div>

				<div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label"><strong>Password</strong></label>
					<div class="col-md-8 inputWrap">
						<input type="password" class="form-control" id="inputPassword"
							placeholder="Password" name="user_password">
					</div>
				</div>

				<div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label"><strong>Nick</strong></label>
					<div class="col-md-8 inputWrap">
						<input type="text" class="form-control" id="inputNickname"
							value="${user_info.user_nickname }" name="user_nickname">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"><strong>Name</strong></label>
					<div class="col-md-8">
						<p class="form-control-static">${user_info.user_name }</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"><strong>Birth</strong></label>
					<div class="col-md-8">
						<p class="form-control-static">${user_info.user_birth }</p>
					</div>
				</div>
				<div>
					<div id="beforeFile">
						기존 첨부파일: <a href="/upload/${attachmentFile.profile_name}"
							download="${attachmentFile.profile_name }">${attachmentFile.profile_name }</a>
						<span id="delFile"
							style="color: red; font-weight: bold; cursor: pointer;">X</span>
					</div>

					<div id="afterFile">
						새 첨부파일: <input type="file" name="file" />
					</div>
				</div>
				<div class="d-grid gap-2 d-md-flex justify-content-md-center"
					style="margin-top: 15px; margin-bottom: 150px; text-align: center;">
					<button type="button" class="btn btn-primary me-md-2"
						id="btnUpdate">수정</button>
					<button type="button" id="btnCancel" class="btn btn-primary ml-1">취소</button>
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {

			//취소버튼 동작
			$("#btnCancel").click(function() {
				history.go(-1);
			});

			$(document).ready(function() {
				//페이지 첫 접속 시 입력창으로 포커스 이동
				$("input").eq(0).focus();
			});

			$("#btnUpdate").click(function() {
				if ($("#inputPassword").val() == '') {
					alert('비밀번호를 입력해주세요');
					$('#inputPassword').focus();
				} else {
					$("#form").submit();
				}

			});

			//파일 삭제 버튼(X) 처리
			$("#delFile").click(function() {
				$("#beforeFile").toggle();
			})

		});
	</script>

	<c:import url="/WEB-INF/views/layout/footer.jsp" />