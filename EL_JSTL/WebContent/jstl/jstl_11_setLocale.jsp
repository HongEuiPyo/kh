<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>fmt:setLocale</h1>
<hr>

<c:set var="now" value="<%=new Date() %>" />
<c:set var="money" value="12345" />

<fmt:setLocale value="ko_kr"/>
	<h3>대한민국</h3>
	통화 : <fmt:formatNumber value="${money }" type="currency"/><br>
	시간 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>

<hr>
<fmt:setLocale value="en_us"/>
	<h3>미국</h3>
	통화 : <fmt:formatNumber value="${money }" type="currency"/><br>
	시간 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
	
<hr>
<fmt:setLocale value="ja_jp"/>
	<h3>일본</h3>
	통화 : <fmt:formatNumber value="${money }" type="currency"/><br>
	시간 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>




<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>












