<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>    
<c:import url="/WEB-INF/views/layout/mypagenav.jsp" />
<div style="display: inline-block; width: 900px; margin-left: 150px; margin-right: 150px; margin-bottom: 200px;" >
<div class="container">
<h1>내가 쓴 글</h1>
<hr>
<h5>커스텀게시판</h5>
<table class="table table-hover table-condensed">
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
			<td><a href="/custom/view?custom_no=${custom.custom_board_no }">${custom.custom_board_title }</a></td>
			<td>${custom.custom_board_date }</td>
			<td>${custom.custom_board_hit }</td>
			<td>${custom.custom_board_vote }</td>
		</tr>
	</c:forEach>
</table>
<h5>자유게시판</h5>
<table class="table table-hover table-condensed">
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
			<td><a href="/free/view?freeboardno=${free.free_board_no }">${free.free_board_title }</a></td>
			<td>${free.free_board_date }</td>
			<td>${free.free_board_hit }</td>
			<td>${free.free_board_vote }</td>
		</tr>
	</c:forEach>

</table>
</div>
</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" /> 
