<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>EL 전달 파라미터 이용</h1>
<hr>

${param }
<hr>

<h3>전달파라미터 하나씩 접근하기</h3>
num1: ${param.num1 }<br>
num2: ${param.num2 }<br>
<hr>

<h3>paramValues 다루기</h3>
${paramValues }

data - ${paramValues.data }<br>
num1 - ${paramValues.num1 }<br>
num2 - ${paramValeus.num2 }<br>
<hr>

data[0] - ${paramValues.data[0] }<br>
data[1] - ${paramValues.data[1] }<br>
data[2] - ${paramValues.data[2] }<br>
data[3] - ${paramValues.data[3] }<br> <%-- 없을 땐 null 반환 --%>


</body>
</html>