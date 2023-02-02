<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>자바영역의 변수를 EL에서 사용하기</h3>
<% int num = 333;  //Java영역에 선언된 변수
%>
num: ${num }<br>
empty num: ${empty num }<br>

<%-- EL구문에서는 Java영역의 변수를 인식할 수 없다 --%>

<hr>

<h3>컨텍스트 영역의 변수를 EL에서 사용하기</h3>
<% pageContext.setAttribute("data", 555); //page 스코프
%>
data: ${data }<br>
empty data: ${empty data }



</body>
</html>