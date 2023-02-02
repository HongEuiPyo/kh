<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<h1 style="margin-top: 100px;">내가 쓴 글</h1>
<hr>

<table class="table table-striped">
	<caption>커스텀게시판</caption>
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>

	<c:forEach items="${customBoardList }" var="custom">
		<tr>
			<td>${custom.custom_board_no }</td>
			<td>${custom.custom_board_title }</td>
			<td>${custom.custom_board_date }</td>
			<td>${custom.custom_board_hit }</td>
			<td>${custom.custom_board_vote }</td>
		</tr>
	</c:forEach>
</table>
<table class="table table-striped">
	<caption>자유게시판</caption>
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	<c:forEach items="${freeBoardList }" var="free">
		<tr>
			<td>${free.free_board_no }</td>
			<td>${free.free_board_title }</td>
			<td>${free.free_board_date }</td>
			<td>${free.free_board_hit }</td>
			<td>${free.free_board_vote }</td>
		</tr>
	</c:forEach>

</table>



<c:import url="/WEB-INF/views/layout/footer.jsp" />
