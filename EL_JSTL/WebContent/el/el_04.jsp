<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>EL ���� �Ķ���� �̿�</h1>
<hr>

${param }
<hr>

<h3>�����Ķ���� �ϳ��� �����ϱ�</h3>
num1: ${param.num1 }<br>
num2: ${param.num2 }<br>
<hr>

<h3>paramValues �ٷ��</h3>
${paramValues }

data - ${paramValues.data }<br>
num1 - ${paramValues.num1 }<br>
num2 - ${paramValeus.num2 }<br>
<hr>

data[0] - ${paramValues.data[0] }<br>
data[1] - ${paramValues.data[1] }<br>
data[2] - ${paramValues.data[2] }<br>
data[3] - ${paramValues.data[3] }<br> <%-- ���� �� null ��ȯ --%>


</body>
</html>