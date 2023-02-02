<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<!-- 'httpRequest' �ҷ����� -->
<script type="text/javascript"	src="<%=request.getContextPath() %>/resources/js/httpRequest.js"></script>

<script type="text/javascript">

function ajaxToServer() {
	console.log("ajaxToserver() called")
	
	//	���� �Ķ����
	var params = 'username=' + document.f.username.value + '<br>' + document.f.content.value;
	
	//	AJAX ��û ������
	sendRequest("POST" , "/ajax/ajax_04_ok.jsp" , params , ajaxFromServer);
}

//	�����κ��� AJAX ������ �޾� ó���ϴ� �Լ�
function ajaxFromServer() {
	console.log("ajaxFromServer() called")
	
	if( httpRequest.readyState == 4 ) {	//	DONE, ���� �Ϸ�
		if (httpRequest.status == 200 ) {	//	200 ok. ���� ����
			console.log("AJAX ���� ����")
			
			//	���� �����͸� div�� �ݿ��ϱ�
			result.innerHTML = httpRequest.responseText;
			
		} else {
			console.log("AJAX ��û/���� ����")
		}
	}
}


</script>


</head>
<body>

<h1>AJAX 04</h1>
<hr>

<form name="f">
username : <input type="text" id="username" /><br>
content : <p><textarea id="content" rows="5" cols="25"></textarea></p><br>
<button type="button" onclick="ajaxToServer();">send</button>
</form>

<hr>

<div id="result"></div>

</body>
</html>