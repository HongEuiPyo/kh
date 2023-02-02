<%@ page import = "dto.Emp" %>
<%@ page import = "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

    
<%
	List<Emp> eList = (List) request.getAttribute("empList");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">
table {
	border-collapse: collapse;
	border : 1px solid #ccc;
	
	width: 1100px;
	margin: 0 auto;
}

td {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	
	padding: 5px 10px;
}

tr:hover {
	background-color: #FAFAD2
}
td:hover {
	background-color: #FAF3C2
}

</style>

</head>
<body>

<h1>Emp 리스트</h1>
<hr>

<table>
<thead>
<tr>
	<th style="width: 10%">사번</th>
	<th style="width: 20%">사원이름</th>
	<th style="width: 15%">직무</th>
	<th style="width: 10%">담당자</th>
	<th style="width: 15%">입사날짜</th>
	<th style="width: 10%">급여</th>
	<th style="width: 10%">상여금</th>
	<th style="width: 10%">부서</th>
</tr>
</thead>

<tbody>
<% for(int i=0; i<eList.size(); i++) {%>
<tr>
	<td><%=eList.get(i).getEmpno() %></td>
	
	<td>
		<a href="/emp/detail?empno=<%=eList.get(i).getEmpno() %>">
			<%=eList.get(i).getEname() %>
		</a>
	</td>
	
	<td><%=eList.get(i).getJob() %></td>
	<td><%=eList.get(i).getMgr() %></td>
	<td><%=eList.get(i).getHiredate() %></td>
	<td><%=eList.get(i).getSal() %></td>
	<td><%=eList.get(i).getComm() %></td>	
	<td><%=eList.get(i).getDeptno() %></td>
</tr>
<% } %>
</tbody>
</table>

</body>
</html>