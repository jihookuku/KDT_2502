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
	<button>글쓰기</button>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list">
		
		</tbody>
	</table>	
</body>
<script>

	listCall(1);

	async function listCall(no){		
		const data = await fetch('list/'+no);
		const result = await data.json();
		console.log(result);
	}
</script>
</html>

















