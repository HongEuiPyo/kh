<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%-- 접근제한자를 포함한 변수 선언 가능 --%>    
<%--	-> 멤버필드로 생성됨 --%>
<%! private int age = 11; %>

<%-------------------------------------%>

<%! //메소드 정의 가능  
	public void method() {
		System.out.println("Hello" + age);
	}
//	method(); //에러, 메소드 호출 안됨
%>    

<%	//메소드 호출은 스크립트릿 태그에서 가능
	method();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>JSP 선언 태그</h1>

</body>
</html>