<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td{
	border: 1px solid black;
	border-collapse: collapse;
}
th, td{
	padding: 5px;
}
</style>
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
			<th>권한</th>
			<td>
				<select name="permission">
					<option value="admin">관리자</option>
					<option value="user">사용자</option>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button>로그인</button>
			</th>
		</tr>
	</table>
	</form>
</body>
<script></script>
</html>




