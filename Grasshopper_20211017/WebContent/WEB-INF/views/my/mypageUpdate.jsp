<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />
		
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
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


<script type="text/javascript">
	$(document).ready(function() {

		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});

	});
</script>
<style type="text/css">
form {
	padding-top: 300px;
	width: 800px;
	margin: 0 auto;
}

#btn {
	text-align: center;
}
</style>
</head>

			<form action="/mypage/update" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="user_no" value="${user_info.user_no }" />

				<table>
					<tr>
						<td>이메일</td>
						<td>${user_info.user_email }</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" name="user_password" value=""
							id="passwordCheck" /></td>
					</tr>
					<tr>
						<td>닉네임</td>
						<td><input type="text" name="user_nickname"
							value="${user_info.user_nickname }" /></td>
					</tr>
					<tr>
						<td>포인트</td>
						<td>${user_info.user_point }</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${user_info.user_name }</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td>${user_info.user_birth }</td>
					</tr>

				</table>

				<div>
					<div id="beforeFile">
						기존 첨부파일: <a href="/upload/${attachmentFile.profile_name}"
							download="${attachmentFile.profile_name }">${attachmentFile.profile_name }</a>
					</div>

					<div id="afterFile">
						새 첨부파일: <input type="file" name="file" />
					</div>
				</div>

				<button>수정</button>
				<button type="button" id="btnCancel">취소</button>

			</form>

			<c:import url="/WEB-INF/views/layout/footer.jsp" />
			
			
			