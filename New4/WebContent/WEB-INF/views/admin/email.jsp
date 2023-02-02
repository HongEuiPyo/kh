<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 마시지 -</title>
<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

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

<!-- 부트스트랩 3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript">
	

window.resizeTo(900, 900);


</script>


<script type="text/javascript">
$(document).ready(function() {
		
	//메일 전송
	$("#btnSend").click(function() {
		$(this).parents("form").submit();
		alert("메일 발송 완료");
			
	/* console.log("전송test")
	window.close(); */
	}) 

	//취소
	$("#btnCancel").click(function() {
		window.close();
	})

});
</script>

<style type="text/css">
#content {
	width: 700;
}
</style>

</head>

<body>
	<div class="wrap">
		<div class="content_area">
			<div class="container">

				<h1 style="margin-top: 100px;">메일 발송</h1>
				<hr>

				<div>
					<div>
					<form action="/kh1/admin/email" method="post" class="form-horizontal" enctype="multipart/form-data">

						<table class="table table-bordered">
							<tr>
								<td class="email">받는사람</td>
							<c:forEach items="${memberList }" var="member">
								<td>${member.user_email }</td>
							</c:forEach>
							</tr>
							<tr>
								<td class="title">제목</td>
								<td><input type="text" name="title" style="width: 100%" /></td>
							</tr>
						
							<tr>
								<td colspan="2"><textarea id="content" name="content"></textarea></td>
							</tr>

						</table>
						첨부파일 <input type="file" name="file" />

				
				

				<div class="text-center">
					<button type="button" id="btnSend" class="btn btn-info">전송</button>
					<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
				</div>
					</form>
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