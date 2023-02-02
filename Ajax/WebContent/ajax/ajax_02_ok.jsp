<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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