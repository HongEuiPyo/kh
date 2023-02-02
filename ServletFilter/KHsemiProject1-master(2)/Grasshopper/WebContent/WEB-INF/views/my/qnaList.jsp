<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>  

<c:import url="/WEB-INF/views/layout/mypagenav.jsp" />
<div style="display: inline-block; width: 900px; margin-left: 150px; margin-right: 150px; margin-bottom: 200px;" >

<div class="container">

	<h1>내가 쓴 문의 내역</h1>
	<hr>

	<table class="table table-hover table-condensed">
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

	<div id="btnBox" class="pull-left" style="text-align: right;">
		<button id="btnWrite" class="btn btn-primary">글쓰기</button>
	</div>

	<!-- .container -->
</div>
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

