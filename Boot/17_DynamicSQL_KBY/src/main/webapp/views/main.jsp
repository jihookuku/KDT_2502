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
		padding : 5px;
	}
	
	div.search_layer{
		font-size:13px;
	}
	
	div.search_layer li{
		list-style-type: none;
		margin-left : -40px;
	}
	
</style>
</head>
<body>
	<form action="list.do" method="get">
		<select name="opt">
			<option value="id">아이디</option>
			<option value="name">이름</option>
			<option value="email">이메일</option>
		</select>
		<input type="text" name="keyword"/>
		<button>검색</button>
	</form>
	
	<h3>회원 리스트</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>삭제</th>
		</tr>
		<c:forEach var = "member" items="${list}">
			<tr>
				<td>${member.id}</td>
				<td><a href="detail.do?id=${member.id}">${member.name}</a></td>
				<td>${member.email}</td>
				<td><a href="del?id=${member.id}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>	
	<div class="search_layer">
		<form action="multi.do" method="post">
			이름이
			<ul>
				<li>
					<input type="text" name="userName"/>
					<input type="button" value="또는" onclick="add(this)"/>
				</li>
			</ul>
			인 회원 찾기
			<button>찾기</button>
		</form>
	</div>
</body>
<script>
function add(elem){
	console.log(elem.parentElement.innerHTML);
	
	// beforebegin : 선택요소 바로 위
	// afterbegin	: 선택요소 첫 자식의 위
	// beforeend	: 선택요소 마지막 자식의 아래
	// afterend		: 선택요소 바로 아래
	document.querySelector('ul').insertAdjacentHTML('beforeend','<li>'+elem.parentElement.innerHTML+'</li>');
	
}


</script>
</html>














