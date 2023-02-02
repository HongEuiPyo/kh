<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
document.ready(function() {
	$("#tomain").click( function() {
		$(location).attr("href", "/member/join");
		
	})
})
</script>
<style type="text/css">
#tomain {
	box-shadow: 3px 3px 3px rgba(0,0,0,0.2);
}
</style>

<title>회원가입 실패</title>
</head>
<body>
<h1>회원가입에 실패하셨습니다</h1>
<button id="tomain">회원가입으로 돌아가기</button>
<hr>
</body>
</html>