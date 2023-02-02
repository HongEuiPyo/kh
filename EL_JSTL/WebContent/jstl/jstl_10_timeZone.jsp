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

<h1>fmt:timeZone</h1>
<hr>

<c:set var="now" value="<%=new Date() %>" />

<fmt:timeZone value="America/New_York">
	뉴욕 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
</fmt:timeZone>

<hr>
<fmt:timeZone value="Asia/Hong_Kong">
	홍콩 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
</fmt:timeZone>

<hr>
<fmt:setTimeZone value="Europe/London"/>
	런던 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
	
<hr>
<fmt:setTimeZone value="Asia/Seoul"/>
	서울 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>




<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>












