<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/common.css" type="text/css">
<style></style>
</head>
<body>
	<h3>수정</h3>
	<form action="update" method="post">
		<input type="hidden" name="idx" value="${bbs.idx}"/>
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${bbs.subject}"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="user_name" value="${bbs.user_name}"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content">${bbs.content}</textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" value="리스트" onclick="location.href='list'"/>
					<button>저장</button>
				</th>
			</tr>
		</table>	
	</form>
</body>
<script></script>
</html>