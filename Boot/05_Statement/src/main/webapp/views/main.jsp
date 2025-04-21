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
	<h3>다음 표를 참고하여 member 테이블을 생성 하세요</h3>
	<table>
		<tr>
			<th>FIELD</th>
			<th>TYPE</th>
			<th>SIZE</th>		
		</tr>
		<tr>
			<td>id</td>
			<td>varchar</td>
			<td>50</td>
		</tr>
		<tr>
			<td>pw</td>
			<td>varchar</td>
			<td>100</td>
		</tr>
		<tr>
			<td>name</td>
			<td>varchar</td>
			<td>50</td>
		</tr>
		<tr>
			<td>age</td>
			<td>int</td>
			<td>3</td>
		</tr>
		<tr>
			<td>gender</td>
			<td>varchar</td>
			<td>4</td>
		</tr>
		<tr>
			<td>email</td>
			<td>varchar</td>
			<td>100</td>
		</tr>
	</table>
	
	<a href="statement">statement 예제</a><br/>
	<a href="preStatement">prepared statement 예제</a><br/>
	<a href="resultSet">result set 예제</a><br/>
	
</body>
<script></script>
</html>




