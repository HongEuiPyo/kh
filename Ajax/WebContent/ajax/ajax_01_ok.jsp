<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>계산 응답 페이지</h1>
<hr>

<c:choose>
<c:when test="${param.oper eq 'add' }">
	${param.num1 } + ${param.num2 } = ${param.num1 + param.num2 }<br>
</c:when>
<c:when test="${param.oper eq 'sub' }">
	${param.num1 } - ${param.num2 } = ${param.num1 - param.num2 }<br>
</c:when>
<c:when test="${param.oper eq 'mul' }">
	${param.num1 } * ${param.num2 } = ${param.num1 * param.num2 }<br>
</c:when>
<c:when test="${param.oper eq 'div' }">
	${param.num1 } / ${param.num2 } = ${param.num1 / param.num2 }<br>
</c:when>
</c:choose>

<a href="/ajax/ajax_01.jsp"><button>다시</button></a>


</body>
</html>