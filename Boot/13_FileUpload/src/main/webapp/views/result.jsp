<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
</head>
<body>
	<c:forEach items="${list}" var="name">
	<p>
		<img src="/file/${name}" width="300px"/>
		<br/>
		<a href="delFile?file=${name}">삭제</a>
		&nbsp;&nbsp;
		<a href="download?file=${name}">다운로드</a>
	</p>
	</c:forEach>
</body>
<script></script>
</html>