<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{
		border : 1px solid black;
		border-collapse: collapse;
	}
	th, td{
		padding: 5px;
	}
</style>
</head>
<body>
	<div>안녕하세요 ${sessionScope.loginId} 님
		<a href="logout">로그아웃</a>
	</div>
	<h3>회원 리스트</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${list}" var="member">
		<tr>
			<td>${member.id}</td>
			<td><a href="detail?id=${member.id}">${member.name}</a></td>
			<td>${member.email}</td>
			<td><a href="del?id=${member.id}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
<script></script>
</html>