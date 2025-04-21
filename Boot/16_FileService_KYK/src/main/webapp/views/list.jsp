<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css 요청을 controller 에서 찾다가 없으면 static 아래의 폴더를 찾는다 -->
<link rel ="stylesheet" href ="css/common.css" type="text/css">
<style>
</style>
</head>
<body>
	<button onclick="location.href='write.go'">글쓰기</button>
	<table>
		<thead>
			<tr>
				<th>idx</th>
				<th>이미지</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${list.size()<1}">
				<tr><th colspan ="5">작성된 글이 없습니다.</th></tr>
			</c:if>
			<c:forEach var="bbs" items="${list}">
				<tr>
					<td>${bbs.idx}</td>
					<th>
					<c:if test="${bbs.cnt>0}">
						<img src="img/image.png" width="25px"/>
					</c:if>
					<c:if test="${bbs.cnt==0}">
						<img src="img/noimage.png" width="25px"/>
					</c:if>
					</th>
					<td><a href="detail.do?idx=${bbs.idx}">${bbs.subject}</a></td>
					<td>${bbs.user_name}</td>
					<td>${bbs.bHit}</td>
					<td>${bbs.reg_date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<script></script>
</html>