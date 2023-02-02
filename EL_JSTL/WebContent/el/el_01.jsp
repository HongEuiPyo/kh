<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>EL 테스트 01 </h1>
<hr>

${"<h3>표현 언어, EL</h3>"}
<h3>${"표현 언어, EL" }</h3>

<hr>

<%="<h3>표현식 태그, Expression</h3>" %>
<h3><%="표현식 태그, Expression" %></h3>

<hr>

<% out.print("<h3>스크립트릿, Scriptlet</h3>"); %>
<h3><% out.print("스크립트릿, Scriptlet"); %></h3>



</body>
</html>