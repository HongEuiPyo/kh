<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style type="text/css">
table {
	text-align: center;
}
table, th, td {
	border: 1px solid #ccc;
	border-collapse: collapse;
}

</style>



</head>
<body>

<h1>���� ���</h1>
<hr>

<a href="/commons/fileupload">COMMONS ���� ���ε�</a>


<table>
<tr>
	<th>��ȣ</th>
	<th>���� �̸�</th>
	<th>����� �̸�</th>
</tr>
<c:forEach var="file" items="${list }">
<tr>
	<td>${file.fileno }</td>
	<td><a href="/upload/${file.storedName}" download="${file.originName }">${file.originName }</a></td>
	<td>${file.storedName }</td>
</tr>
</c:forEach>
</table>


</body>
</html>