<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<!-- 스마트에디터 2 -->
<script type="text/javascript"
	src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style type="text/css">
#content {
	/* 	width: 100%; */
	width: 98%;
}
</style>

<div class="container" style="margin-top:100px; margin-bottom: 150px;">

	<h1>문의합니다</h1>
	<hr>

	<div>
		<form action="/qna/write" method="post" enctype="multipart/form-data">

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
					<td colspan="2"><textarea id="content" name="content" style="height: 300px;"></textarea></td>
				</tr>
			</table>

			첨부파일 <input type="file" name="file" />

		</form>
	</div>

	<div class="text-center">
		<button type="button" id="btnWrite" class="btn btn-primary me-md-2">작성</button>
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

		$(document).ready(function() {
			//페이지 첫 접속 시 입력창으로 포커스 이동
			$("input").eq(0).focus();
		});

	});
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />