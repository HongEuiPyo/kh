<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>c:set</h1>
<h3>���� ������ Ȯ��</h3>
<hr>

���� ������: ${sessionData }<br>

<a href="./jstl_03.jsp">���� ������</a>

<hr>

A key : ${m.A}<br>
B key : ${m.B }<br><br>

A key: ${m.get("A") }<br>
B key: ${sessionScope.m.get("B") }<br><br>

<%
	out.print("A key: ");
// 	out.print( (Map) request.getSession().getAttribute("m").get("A"));
%>

</body>
</html>