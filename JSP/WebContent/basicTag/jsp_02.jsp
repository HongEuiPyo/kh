<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%-- ���������ڸ� ������ ���� ���� ���� --%>    
<%--	-> ����ʵ�� ������ --%>
<%! private int age = 11; %>

<%-------------------------------------%>

<%! //�޼ҵ� ���� ����  
	public void method() {
		System.out.println("Hello" + age);
	}
//	method(); //����, �޼ҵ� ȣ�� �ȵ�
%>    

<%	//�޼ҵ� ȣ���� ��ũ��Ʈ�� �±׿��� ����
	method();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>JSP ���� �±�</h1>

</body>
</html>