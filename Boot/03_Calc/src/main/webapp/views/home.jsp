<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
</head>
<body>
	<form action="calc" method="post">
		<input type="text" name="val1"/>
		
		<select name="oper">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select>
		
		<input type="text" name="val2"/>
		<input type="submit" value="전송"/>
	</form>
</body>
<script></script>
</html>