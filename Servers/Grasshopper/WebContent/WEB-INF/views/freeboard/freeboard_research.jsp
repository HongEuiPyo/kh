<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>
<<script type="text/javascript">
$(document).ready(function() {
	$("#btnwrite").click(function() {
		location.href="/free/write";
	});
	
	$("#btnSearch").click(function(){
		if( $("#btnSearch").val() == null){
			alert("검색어를 입력하세요");
			return ;
		}
		location.href="/free/search";
	})
});
</script>

<h1>자유게시판</h1>
<h3>검색 결과</h3>
<hr>

<table class="table table-striped">
<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>조회수</th>
	<th>작성일</th>
</tr>

<div style="margin: auto 5%;">
<c:forEach items="${boardList }" var="board">
<tr>
	<td>${board.free_board_no }</td>
	<td>
		<a href="/free/view?freeboardno=${board.free_board_no }">
		${board.free_board_title }
		</a>
	</td>
	<td>${board.user_nickname}</td>
	<td>${board.free_board_hit }</td>
	<td>${board.free_board_date }</td>
</tr>
</c:forEach>

</table>


<button id="btnwrite" class="btn btn-info float-right" style="float:right">글 쓰기</button>

<c:import url="/WEB-INF/views/layout/freeboard_search_paging.jsp"/>

<form action="<%=request.getContextPath() %>/free/search" method="get">
<div style="text-align:center">
<select id="type" name="type">
	<option value="title">제목</option>
	<option value="content">본문 내용</option>
	<option value="writer">작성자</option>
</select>
<input type="text" id="search" name="search"/>
<button type="submit" class="btn btn-default btn-sm" id="btnSearch">검색</button>
<input type="hidden" id="searchvalue" value="${searchvalue }"/>
<input type="hidden" id="typevalue" value="${typevalue }"/>
</div>
</form>

</div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />