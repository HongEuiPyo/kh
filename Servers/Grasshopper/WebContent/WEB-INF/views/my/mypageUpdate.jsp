<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<h3 style="text-align: center; margin-top: 100px;">내 정보 수정하기</h3>
<form class="form-horizontal row justify-content-md-center m1"
	action="/mypage/update" method="post" enctype="multipart/form-data"
	id="form">
	<div class="col-md-auto mt-2 mb-5">
		<input type="hidden" name="user_no" value="${user_info.user_no }" />
		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>Email</strong></label>
			<div class="col">
				<p class="form-control-static">${user_info.user_email }</p>
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 control-label"><strong>Password</strong></label>
			<div class="col">
				<input type="password" class="form-control" id="inputPassword"
					placeholder="Password" name="user_password">
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 control-label"><strong>Nick</strong></label>
			<div class="col">
				<input type="text" class="form-control" id="inputNickname"
					value="${user_info.user_nickname }" name="user_nickname">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>Name</strong></label>
			<div class="col">
				<p class="form-control-static">${user_info.user_name }</p>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>Birth</strong></label>
			<div class="col">
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
			style="margin-top: 15px; margin-bottom: 60px;">
			<button type="button" class="btn btn-primary me-md-2" id="btnUpdate">수정</button>
			<button type="button" id="btnCancel" class="btn btn-primary ml-1">취소</button>
		</div>
	</div>
</form>


<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td>이메일</td> -->
<%-- 			<td>${user_info.user_email }</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>비밀번호</td> -->
<!-- 			<td><input type="text" name="user_password" value="" -->
<!-- 				id="passwordCheck" /></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>닉네임</td> -->
<!-- 			<td><input type="text" name="user_nickname" -->
<%-- 				value="${user_info.user_nickname }" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>포인트</td> -->
<%-- 			<td>${user_info.user_point }</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>이름</td> -->
<%-- 			<td>${user_info.user_name }</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>생년월일</td> -->
<%-- 			<td>${user_info.user_birth }</td> --%>
<!-- 		</tr> -->

<!-- 	</table> -->


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
