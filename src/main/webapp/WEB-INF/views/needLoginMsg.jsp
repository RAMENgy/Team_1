<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 필요!</title>
</head>
<body>
<script type="text/javascript">
	alert("로그인 후 사용 가능합니다!");
	location.href = "${pageContext.request.contextPath }/member/login";
</script>
</body>
</html>