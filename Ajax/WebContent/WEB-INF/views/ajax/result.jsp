<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

RESULT ¿¿¥‰

<table border="1">
<c:forEach items="${list }" var="mem">
<tr>
	<td>${mem.id }</td>
	<td>${mem.pw }</td>
</tr>
</c:forEach>
</table>