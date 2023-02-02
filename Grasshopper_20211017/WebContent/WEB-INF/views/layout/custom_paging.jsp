<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
//window.location.search = ?를 포함한 이후 문자열
var params = new URLSearchParams(window.location.search);
var category = params.get("category");
var search = params.get("search");

</script>

<div class="text-center">
<nav>
  <ul class="pagination">
  	
  	<%--첫 페이지로 이동 --%>
  	<c:if test="${paging.curPage ne 1 }">
  		<li><a href="/custom/list">첫 페이지로</a></li>
  	</c:if>
  	
  	<%-- 이전 페이징 리스트로 이동 --%>
	<c:choose>
	<c:when test="${paging.startPage ne 1 }">
  		<li><a href="/custom/list?category=${category }&search=${search }&curPage=${paging.startPage - paging.pageCount }">&laquo;</a></li>
  	</c:when>
  	<c:when test="${paging.startPage eq 1 }">
  		<li class="disable"><a>&laquo;</a></li>
	</c:when>
	</c:choose>
	
	<%-- 이전 페이지로 가기 --%>
	<c:if test="${paging.curPage > 1 }">
		<li><a href="/custom/list?category=${category }&search=${search }&curPage=${paging.curPage - 1 }">&lt;</a></li>
	</c:if>
	
    <%-- 페이징 리스트 --%>
  	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
  		<c:if test="${paging.curPage eq i }">
  			<li class="active"><a href="/custom/list?category=${category }&search=${search }&curPage=${i }">${i }</a></li>
		</c:if>			
  		<c:if test="${paging.curPage ne i }">
  			<li><a href="/custom/list?category=${category }&search=${search }&curPage=${i }">${i }</a></li>
		</c:if>			
  	</c:forEach>
  	
  	<%-- 다음 페이지로 가기 --%>
	<c:if test="${paging.curPage < paging.totalPage }">
		<li><a href="/custom/list?category=${category }&search=${search }&curPage=${paging.curPage + 1 }">&gt;</a></li>
	</c:if>
    
  	
  	<%-- 다음 페이지 리스트로 이동--%>
  	<c:choose>
  	<c:when test="${paging.endPage ne paging.totalPage }">
  		<li><a href="/custom/list?category=${category }&search=${search }&curPage=${paging.startPage + paging.pageCount }">&raquo;</a></li>
  	</c:when>
  	<c:when test="${paging.endPage eq paging.totalPage }">
  		<li><a class="disabled">&raquo;</a></li>
	</c:when>
	</c:choose>
	
	<%-- 마지막 페이지로 --%>
    <c:if test="${paging.curPage ne paging.totalPage }">
  		<li><a href="/custom/list?category=${category }&search=${search }&curPage=${paging.totalPage }">마지막 페이지로</a></li>
  	</c:if>
  </ul>
</nav>

</div>
