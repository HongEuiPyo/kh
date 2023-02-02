<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>fmt:formatDate</h1>
<hr>

<%	Date date = new Date(); %>

<c:set var="now" value="<%=new Date() %>" />
now: ${now }
<hr>

default: <fmt:formatDate value="${now }" type="date" /><br>
default: <fmt:formatDate value="${now }" type="time" />
<hr>

default: <fmt:formatDate value="${now }" type="date" dateStyle="default" /><br>
short: <fmt:formatDate value="${now }" type="date" dateStyle="short" /><br>
medium: <fmt:formatDate value="${now }" type="date" dateStyle="medium" /><br>
long: <fmt:formatDate value="${now }" type="date" dateStyle="long" /><br>
full: <fmt:formatDate value="${now }" type="date" dateStyle="full" /><br>
<hr>

default: <fmt:formatDate value="${now }" type="time" dateStyle="default" /><br>
short: <fmt:formatDate value="${now }" type="time" dateStyle="short" /><br>
medium: <fmt:formatDate value="${now }" type="time" dateStyle="medium" /><br>
long: <fmt:formatDate value="${now }" type="time" dateStyle="long" /><br>
full: <fmt:formatDate value="${now }" type="time" dateStyle="full" /><br>
<hr>

both: <fmt:formatDate value="${now }" type="both" /><br>

both: <fmt:formatDate value="${now }" type="both" 
	dateStyle="full" timeStyle="full" />
<hr>

yyyy-MM-dd: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd" /><br>
yyMMdd: <fmt:formatDate value="${now }" pattern="yyMMdd" /><br>

yyMMdd: <fmt:formatDate value="${now }" 
	pattern="yy/MM/dd HH:mm:ss.S" />
</body>
</html>






























