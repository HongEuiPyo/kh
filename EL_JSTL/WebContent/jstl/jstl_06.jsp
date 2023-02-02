<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
div {
	text-align: center;
}

#gugudan div[id^='res']:hover {
	backgournd: #AECDFF;
}

#gugudan .result {
	border: 1px solid #ccc;
	width: 100px;
	display: inline-block;
	
	padding: 5px 0;
	margin: 1px 5px;
	
	cursor: pointer;
}

#gugudan .row {

}

</style>

</head>
<body>

<h1>c:forEach</h1>
<hr>

<c:forEach var="i" begin="1" end="10">
<h3>${i }</h3>
</c:forEach>

<%-- step 속성을 지정하지 않으면 기본값 1 --%>

<hr>

<%-- 1~100까지의 합 구하기 --%>

<c:set var="sum" value="0"/>

<c:forEach var="i" begin="1" end="100">
	<c:set var="sum" value="${sum + i }" />
</c:forEach>

<h3>1~100의 합: ${sum }</h3>

<hr>
<br><br>


<!-- <div id="gugudan"> -->
<%-- <c:forEach var="i" begin="1" end="9"> --%>

<!-- 	<div class="row"> -->
<%-- 	<c:forEach var="dan" begin=2 end="9"> --%>
	
<%-- 		<div class="result" id="res${i }"> --%>
<%-- 		<c:out value="${dan } x ${i } = ${dan*i }" /> --%>
<!-- 		</div> -->
		
<%-- 	</c:forEach> --%>
<!-- 	</div> -->

<!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->
<%-- </c:forEach> --%>
<!-- </div> -->

<hr>

<h3>Iterator로 사용하기</h3>

<% Map<Integer, String> map = new HashMap<>(); %>
<% map.put(1, "Apple"); %>
<% map.put(2, "Banana"); %>
<% map.put(3, "Cherry"); %>

<c:forEach var="iter" items="<%=map %>">

	${iter }<br>
	${iter.key } : ${iter.value }<br>
	--------<br>
</c:forEach>

<hr>

<table border="1">
<tr>
	<th>키</th>
	<th>값</th>
</tr>	
<c:forEach var="iter" items="<%=map %>">
<tr>
	<td>${iter.key }</td>
	<td>${iter.value }</td>
</tr>
</c:forEach>
</table>

<hr>

<%	List<String> list = new ArrayList<>(); 
	list.add("Alice");
	list.add("Bob");
	list.add("Clare");
	list.add("Dave");
	list.add("Edward");
%>

<%-- List의 인덱스를  begin, end, step 속성으로 조절 가능 --%>

<c:forEach var="iter" items="<%=list %>"
	begin="1" end="4" step="1"
	varStatus="stat">
	
	<c:if test="${stat.first }">
	<div style= "color:red; font-size: 0.5em;">첫번째 반복</div>
	</c:if>
	 
	iter: ${iter }<br>
	인덱스: ${stat.index }<br>
	실행 횟수: ${stat.count }<br>
	
	first: ${stat.first }<br>
	last: ${stat.last }<br>
	
	step: ${stat.step }<br>
	
	<c:if test="${not stat.last }">
	------------------<br>
	</c:if>
	
	<c:if test="${stat.last }">
	<div style= "color:red; font-size: 0.5em;">마지막 반복</div>
	</c:if>
	
</c:forEach>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>























