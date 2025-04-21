<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/common.css" type="text/css">
</head>
<body>

	<button onclick="location.href='writeForm'">글쓰기</button>

	<table>
		<thead>
			<tr>
				<th>idx</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${list.size() < 1}">
				<tr><th colspan="5">작성된 글이 없습니다.</th></tr>
			</c:if>
			<c:forEach items="${list}" var="bbs">
				<tr> 
					<td>${bbs.idx}</td>
					<td> <a href="detail?idx=${bbs.idx}">${bbs.subject}</a></td>
					<td>${bbs.user_name}</td>
					<td>${bbs.bHit}</td>
					<td>${bbs.reg_date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<script>

</script>
</html>