<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<c:import url="/WEB-INF/views/layout/mypagenav.jsp" />
<div style="display: inline-block; width: 900px; margin-left: 150px; margin-right: 150px; margin-bottom: 200px;" >

<div class="container">

	<h1>문의 상세 보기</h1>
	<hr>

	<table class="table table-bordered">
		<tr>
			<td class="info">닉네임</td>
			<td colspan="3">${user_info.user_nickname }</td>
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
			<td colspan="4" style="height: 350px">${viewBoard.qna_board_content }</td>
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


</div>

<c:forEach items="${qna_board_reply}" var="qna_board_reply">
	<c:if test="${qna_board_reply.qna_board_no eq viewBoard.qna_board_no }">
		<div class="container">
			<div class="card"
				style="background-color: #ededed; margin-top: 40px;">
				<div class="card-body">
					<p class="h5">관리자 답변</p>
					${qna_board_reply.qna_reply_content }
				</div>
			</div>
		</div>
	</c:if>
</c:forEach>

<c:if test="${user_info.user_no eq 2 }">
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
<div class="text-center">
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
														.attr("href",
																"/qna/delete?boardno=${viewBoard.qna_board_no }");
											}
										});

						$(document).ready(function() {
							//페이지 첫 접속 시 입력창으로 포커스 이동
							$("input").eq(0).focus();
						});

					});
</script>



<c:import url="/WEB-INF/views/layout/footer.jsp" />