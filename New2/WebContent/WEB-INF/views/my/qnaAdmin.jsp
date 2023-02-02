<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />



<div class="container">

	<h1 style="margin-top: 100px;">또 뭐가 문젠데 새기드라...</h1>
	<hr>

	<table class="table table-striped table-hover table-condensed">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>

		<c:forEach items="${boardList }" var="qna">
			<tr>
				<td>${qna.qna_board_no }</td>
				<td><a href="/qna/view?boardno=${qna.qna_board_no }">
						${qna.qna_board_title } </a></td>
				<td>${qna.qna_board_date }</td>
			</tr>
		</c:forEach>

	</table>

	<div id="btnBox" class="pull-left">
		<button id="btnWrite" class="btn btn-primary">글쓰기</button>
	</div>

	<!-- .container -->
</div>

<script type="text/javascript">
	$(document).ready(function() {

		//글쓰기 버튼 누르면 이동
		$("#btnWrite").click(function() {
			location.href = "/qna/write";
		});

	});
</script>


<c:import url="/WEB-INF/views/layout/footer.jsp" />


