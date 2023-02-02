<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<h1 style="margin-top: 100px;">내가 쓴 댓글</h1>
<hr>

<table class="table table-striped">
	<caption>자유게시판 댓글</caption>
	<tr>
		<th>글번호</th>
		<th>댓글내용</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${freeBoardReply }" var="freeReply">
		<tr>
			<td>${freeReply.free_board_no }</td>
			<td>${freeReply.free_reply_content }</td>
			<td>${freeReply.free_reply_date }</td>
		</tr>
	</c:forEach>
</table>

<table class="table table-striped">
	<caption>커스텀게시판 댓글</caption>
	<tr>
		<th>글번호</th>
		<th>댓글내용</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${customReply }" var="customReply">
		<tr>
			<td>${customReply.custom_board_no }</td>
			<td>${customReply.custom_reply_content }</td>
			<td>${customReply.comment_date }</td>
		</tr>
	</c:forEach>
</table>

<table class="table table-striped">
	<caption>오피셜게시판 댓글</caption>
	<tr>
		<th>글번호</th>
		<th>댓글내용</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${officialReply }" var="officialReply">
		<tr>
			<td>${officialReply.official_board_no }</td>
			<td>${officialReply.official_reply_content }</td>
			<td>${officialReply.official_reply_date }</td>
		</tr>
	</c:forEach>
</table>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
