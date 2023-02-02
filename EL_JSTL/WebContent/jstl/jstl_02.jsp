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

<h1>c:out</h1>
<hr>

<c:out value="Hello! JSTL" />
<hr>

elData: <c:out value="${elData }" /><br>
empty elData: <c:out value="${empty elData }" />
<hr>

<%-- �߸� ������ ��� --%>
<c:out value="" default="�� ���ڿ� ���" /><br>
<c:out value="null" default="null ���" />

EL null:<c:out value="${null }" default="EL null�� ��� "/><br>
Expression null: <c:out value="<%=null %>" default="Expression null�� ���"/><br>

<c:out value="<h3>�±� ���</h3>"/>
<c:out value="<h3>�±� ���</h3>" escapeXml="false"/>

<hr>
<%="<h3> �±� ���</h3>" %>
<%="&lt;h3&gt;�±� ���&lt;/h3&gt;" %>

<hr>

����: %nbsp;<br>

���� 2�� ����: &laquo;<br>
������ 2�� ����: &raquo;<br>

���� ȭ��ǥ: &larr;<br>
������ ȭ��ǥ: &rarr;<br>

copyright: &copy;

</body>
</html>