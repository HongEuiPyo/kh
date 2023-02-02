<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<c:import url="/WEB-INF/views/layout/mypagenav.jsp" />

<div style="display: inline-block; width: 900px; margin-left: 150px; margin-right: 150px; margin-bottom: 200px;" >

<div class="container">
<h1>내가 쓴 댓글</h1>
<hr>
<h5>자유게시판 댓글</h5>
<table class="table table-hover table-condensed">
	<tr>
		<th>글번호</th>
		<th>댓글내용</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${freeBoardReply }" var="freeReply">
		<tr>
			<td>${freeReply.free_board_no }</td>
			<td><a href="/free/view?freeboardno=${freeReply.free_board_no }">${freeReply.free_reply_content }</a>
			</td>
			<td>${freeReply.free_reply_date }</td>
		</tr>
	</c:forEach>
</table>

<h5>커스텀게시판 댓글</h5>
<table class="table table-hover table-condensed">
	<tr>
		<th>글번호</th>
		<th>댓글내용</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${customReply }" var="customReply">
		<tr>
			<td>${customReply.custom_board_no }</td>
			<td><a href="/custom/view?custom_no=${customReply.custom_board_no }">
			${customReply.custom_reply_content }</a></td>
			<td>${customReply.comment_date }</td>
		</tr>
	</c:forEach>
</table>

<h5>오피셜게시판 댓글</h5>
<table class="table table-hover table-condensed">
	<tr>
		<th>글번호</th>
		<th>댓글내용</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${officialReply }" var="officialReply">
		<tr>
			<td>${officialReply.official_board_no }</td>
			<td><a href="/official/view?official_no=${officialReply.official_board_no }">${officialReply.official_reply_content }</a></td>
			<td>${officialReply.official_reply_date }</td>
		</tr>
	</c:forEach>
</table>
</div>
</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
