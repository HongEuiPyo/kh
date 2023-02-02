<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>c:set</h1>
<hr>

<%-- ���� ���ؽ�Ʈ ���� ����(���) --%>
<c:set var="sessionData" value="SESSION_DATA" scope="session"/>

<a href="./jstl_03_session.jsp">���� Ȯ��</a>

<hr>

<% Map map = new HashMap(); //�� ����%>
<%-- ��µ��� �ʴ´�, ���ؽ�Ʈ ������ ��ϵǾ����� ���� --%>
map : ${map }<br><br>

<%-- JSTL�� �̿��� Map��ü�� ������Ƽ ���� --%>
<c:set target="<%=map%>" property="A" value="Alice"/>
<c:set target="<%=map %>" property="B" value="Bob" />

A key: <%=map.get("A") %><br>
B key: ${map.B }<br>

<hr>
<%-- JSTL�� �̿��Ͽ� Map��ü�� session������ ����ϱ� --%>
<c:set var="m" value="<%=map %>" scope="session"/>

m: ${m }<br>

<hr>

<%-- User DTO�� �̿��� �ڹٺ� ��ü ���� --%>
<jsp:useBean id="ud" class=dto.User/>
ud: ${ud }



</body>
</html>