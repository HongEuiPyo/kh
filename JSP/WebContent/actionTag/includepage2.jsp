<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<div id="subpage2">
<h3>�߰��� ������ ����</h3>
</div>

<% String data = request.getParameter("data"); %>
<% if( data!=null && !"".equals(data) ) { %>
<p>���� �Ķ���� : <%=data %></p>
<% } else { %>
<p>���ް��� �����ϴ�</p>
<% } %>