<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<div id="subpage2">
<h3>추가된 페이지 영역</h3>
</div>

<% String data = request.getParameter("data"); %>
<% if( data!=null && !"".equals(data) ) { %>
<p>전달 파라미터 : <%=data %></p>
<% } else { %>
<p>전달값이 없습니다</p>
<% } %>