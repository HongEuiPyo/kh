<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

HELLO JSP

<br>
<%
// 	out.print( request.getParameter("uid") );
%>

uid : <%= request.getParameter("uid") %>

<br>
<%= response.getCharacterEncoding() %>



<hr>

<%= page %>

<%-- 초기화 파라미터 (InitParam) --%>
<%--	web.xml(배포관리자)를 통해 등록된 초기화 파라미터에 접근할 때
		config(ServletConfig)객체를 사용한다 --%>
<%=config.getInitParameter("data") %>

<br>
<%=config.getServletName() %>



</body>
</html>


























