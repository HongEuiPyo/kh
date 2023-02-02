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

<%-- 세션 컨텍스트 정보 삽입(등록) --%>
<c:set var="sessionData" value="SESSION_DATA" scope="session"/>

<a href="./jstl_03_session.jsp">세션 확인</a>

<hr>

<% Map map = new HashMap(); //맵 생성%>
<%-- 출력되지 않는다, 컨텍스트 정보로 등록되어있지 않음 --%>
map : ${map }<br><br>

<%-- JSTL을 이용한 Map객체의 프로퍼티 삽입 --%>
<c:set target="<%=map%>" property="A" value="Alice"/>
<c:set target="<%=map %>" property="B" value="Bob" />

A key: <%=map.get("A") %><br>
B key: ${map.B }<br>

<hr>
<%-- JSTL을 이용하여 Map객체를 session정보로 등록하기 --%>
<c:set var="m" value="<%=map %>" scope="session"/>

m: ${m }<br>

<hr>

<%-- User DTO를 이용한 자바빈 객체 생성 --%>
<jsp:useBean id="ud" class=dto.User/>
ud: ${ud }



</body>
</html>