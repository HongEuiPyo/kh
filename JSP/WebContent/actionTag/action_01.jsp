<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>액션태그 테스트</h1>
<hr>
<jsp:useBean id="user1" class="dto.User"/>

<% User user2 = new User(); %>

user2: <%= user2 %><br>

<hr>

<% user1.setUserid("id1"); 
   user1.setUserpw("pw1");
   
   user2.setUserid("id2");
   user2.setUserpw("pw2");
%>

user1: <%=user1 %><br>


<jsp:useBean id="user3" class="dto.User" />

<% User user4 = new User(); %>

<jsp:setProperty property="userid" name="user3" value="id3" />
<jsp:setProperty property="userpw" name="user3" value="pw3" />
user3:  <%=user3 %><br>

<%-- 에러발생! --%>
<%--	user4가 컨텍스트영역에 존재하지 않아 null처리됨 --%>
<%-- <jsp:setProperty property="userid" name="user4" value="id4" /> --%>

<%-- 해결법 --%>
<%--	자바영역의 객체를 컨텍스트 영역에 등록한다 --%>
<% pageContext.setAttribute("user4", user4); 
// 	request.setAttribute("user4", user4);
// 	session.setAttribute("user4", user4);
// 	application.setAttribute("user4", user4);
%>
<jsp:setProperty property="userid" name="user4" value="id4" />
<jsp:setProperty property="userpw" name="user4" value="pw4" />

user4: <%=user4 %>

</body>
</html>