<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="resources/img/favicon.ico">
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<style></style>
</head>
<body>
	<form action="login.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<th colspan="2">
					<button>login</button>
					<button type="button" onclick="location.href='join.go'">회원가입</button>
				</th>
			</tr>
		</table>	
	</form>
</body>
<script>
	const msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}

</script>
</html>



