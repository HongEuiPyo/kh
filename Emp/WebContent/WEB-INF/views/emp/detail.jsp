<%@ page import = "dto.Emp" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%
	Emp result = (Emp) request.getAttribute("emp");
%>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<table>
<thead>
<tr>
	<th style="width: 10%">���</th>
	<th style="width: 20%">����̸�</th>
	<th style="width: 15%">����</th>
	<th style="width: 10%">�����</th>
	<th style="width: 15%">�Ի糯¥</th>
	<th style="width: 10%">�޿�</th>
	<th style="width: 10%">�󿩱�</th>
	<th style="width: 10%">�μ�</th>
</tr>
</thead>
<tr>
	<td><%=result.getEmpno() %></td>
	<td><%=result.getEname() %></td>
	<td><%=result.getJob() %></td>
	<td><%=result.getMgr() %></td>
	<td><%=result.getHiredate() %></td>	
	<td><%=result.getSal() %></td>	
	<td><%=result.getComm() %></td>	
	<td><%=result.getDeptno() %></td>	
</tr>
</table>
</body>
</html>