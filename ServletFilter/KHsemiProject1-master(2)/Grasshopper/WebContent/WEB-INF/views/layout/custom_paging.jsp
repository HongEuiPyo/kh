<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
//window.location.search = ?를 포함한 이후 문자열
var params = new URLSearchParams(window.location.search);
var category = params.get("category");
var search = params.get("search");

</script>

<style>
.center {
  text-align: center;
}
.pagination {
  display: inline-block;

}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border-radius: 5px;
}

.pagination a:hover:not(.active) {
  background-color: #ddd;
  border-radius: 5px;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<br>
<div class="center">
<div class="pagination">
  	<%--첫 페이지로 이동 --%>
  	<c:if test="${paging.curPage ne 1 }">
  		<a href="/custom/list">첫 페이지로</a>
  	</c:if>
  	
  	<%-- 이전 페이징 리스트로 이동 --%>
	<c:choose>
	<c:when test="${paging.startPage ne 1 }">
  		<a href="/custom/list?category=${category }&search=${search }&curPage=${paging.startPage - paging.pageCount }">&laquo;</a>
  	</c:when>
  	<c:when test="${paging.startPage eq 1 }">
  		<a class="disable">&laquo;</a>
	</c:when>
	</c:choose>
	
	<%-- 이전 페이지로 가기 --%>
	<c:if test="${paging.curPage > 1 }">
		<a href="/custom/list?category=${category }&search=${search }&curPage=${paging.curPage - 1 }">&lt;</a>
	</c:if>
	
    <%-- 페이징 리스트 --%>
  	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
  		<c:if test="${paging.curPage eq i }">
  			<a class="active" href="/custom/list?category=${category }&search=${search }&curPage=${i }">${i }</a>
		</c:if>			
  		<c:if test="${paging.curPage ne i }">
  			<a href="/custom/list?category=${category }&search=${search }&curPage=${i }">${i }</a>
		</c:if>			
  	</c:forEach>
  	
  	<%-- 다음 페이지로 가기 --%>
	<c:if test="${paging.curPage < paging.totalPage }">
		<a href="/custom/list?category=${category }&search=${search }&curPage=${paging.curPage + 1 }">&gt;</a>
	</c:if>
    
  	
  	<%-- 다음 페이지 리스트로 이동--%>
  	<c:choose>
  	<c:when test="${paging.endPage ne paging.totalPage }">
  		<a href="/custom/list?category=${category }&search=${search }&curPage=${paging.startPage + paging.pageCount }">&raquo;</a>
  	</c:when>
  	<c:when test="${paging.endPage eq paging.totalPage }">
  		<a class="disabled">&raquo;</a>
	</c:when>
	</c:choose>
	
	<%-- 마지막 페이지로 --%>
    <c:if test="${paging.curPage ne paging.totalPage }">
  		<a href="/custom/list?category=${category }&search=${search }&curPage=${paging.totalPage }">마지막 페이지로</a>
  	</c:if>

</div>
</div>
