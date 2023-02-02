<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
<c:when test="${param.oper eq 'add' }">
	${param.n1 } + ${param.n2 } = ${param.n1 + param.n2 }
</c:when>
<c:when test="${param.oper eq 'sub' }">
	${param.n1 } - ${param.n2 } = ${param.n1 - param.n2 }
</c:when>
<c:when test="${param.oper eq 'mul' }">
	${param.n1 } * ${param.n2 } = ${param.n1 * param.n2 }
</c:when>
<c:when test="${param.oper eq 'div' }">
	${param.n1 } / ${param.n2 } = ${param.n1 / param.n2 }
</c:when>
</c:choose>