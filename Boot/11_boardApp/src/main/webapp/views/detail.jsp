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
		<table>
			<tr>
				<th>제목</th>
				<td>${bbs.subject}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bbs.user_name}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${bbs.reg_date}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${bbs.bHit}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bbs.content}</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" value="리스트" onclick="location.href='list'"/>
					<input type="button" value="삭제" 
						onclick="location.href='del?idx=${bbs.idx}'"/>
					<input type="button" value="수정" 
						onclick="location.href='updateForm?idx=${bbs.idx}'"/>
				</th>
			</tr>
		</table>	
</body>
<script></script>
</html>