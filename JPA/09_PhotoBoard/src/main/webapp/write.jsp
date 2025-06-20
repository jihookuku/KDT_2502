<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="img/favicon.ico">
<link rel="stylesheet" href="css/common.css" type="text/css">
<title>Insert title here</title>
<style></style>
</head>
<body>
	<h3>글쓰기</h3>
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject"/></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="user_name"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content"></textarea></td>
		</tr>
		<tr>
			<th>사진</th>
			<td>
				<input type="file" name="files" />
				<div id="prev"></div>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="location.href='./'">리스트</button>
				<button onclick="save()">저장</button>
			</th>
		</tr>
	</table>
	
	
</body>
<script></script>
</html>