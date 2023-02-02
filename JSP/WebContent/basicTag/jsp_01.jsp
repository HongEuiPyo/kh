<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello JSP!</h1>
<hr>

<%-- 스크립트릿 태그 --%>
<%-- 	자바코드를 작성하는 영역  --%>
<%	String name = "Alice"; 
	System.out.println(name); //톰캣서버 콘솔 출력
%>

<%----------------------------------------------%>

<%	for(int i=0; i<3; i++) {%>
<h3>스크립트릿 + HTML코드 작성</h3>
<% } %>

<%----------------------------------------------%>
<hr>

<%	//스크립트릿 내부에서 자바 주석 사용 가능
//	스크립트릿에서는 메소드를 정의할 수 없다
//	public void method() {
	
//	}
%>

<%	//접근제한자를 사용한 변수(멤버 필드) 선언 불가
//	privaate int num = 100;
%>

<%	//import할 수 없다
//	import java.util.Date;
%>



















</body>
</html>