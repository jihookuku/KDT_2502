<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>안냐세욤 리스트에용</title>
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<link rel="icon" href="resources/img/favicon.ico">
<style></style>
</head>
<body>
	<button onclick="location.href='write.go'">글쓰기</button>
	<table>
		<thead>
			<tr>
				<th>🔢 번호</th>
				<th>🖼 이미지</th>
				<th>✒ 제목</th>
				<th>👩 작성자</th>
				<th>🔍 조회수</th>
				<th>📅 등록일</th>
				<th>🗑 삭제</th>
			</tr>
		</thead>
		<tbody id="list">
		
		</tbody>
	</table>	
</body>
<script>
	//listCall(1);

	async function listCall(no){		
		const data = await fetch('list/'+no);
		const result = await data.json();
		console.log(result);
		
		console.log(result.list[0]);
		
		let content = result.list.length>0?'':'<tr><th colspan="7">작성된 게시물이 없습니다.</th></tr>';
		
		for(let item of result.list){
			content += '<tr>';
			content += '<td>'+item.idx+'</td>';
			content += '<th>';
			content += '<img class="icon" src="resources/img/'+(item.img>0 ? 'image.png':'noimage.png')+'"/>';
			content += '</th>';
			content += '<td><a href="detail.go?idx='+item.idx+'">'+item.subject+'</a></td>';
			content += '<td>'+item.userName+'</td>';
			content += '<td>'+item.bhit+'</td>';
			content += '<td>'+item.reg_date+'</td>';
			content += '<td><a href="./delete?idx='+item.idx+'">삭제</a></td>';
			content += '</tr>';
		}
		
		document.querySelector('#list').innerHTML = content;		
		
	}
</script>
</html>
















