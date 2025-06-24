<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="resources/img/favicon.ico">
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<style></style>
</head>
<body>
	<form action="join.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="id"/>
					<button type="button" onclick="overlay()">중복체크</button><br/>
					<span id="msg"></span>					
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="pw"/></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<th>AGE</th>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<th>GENDER</th>
				<td>
					남자 : <input type="radio" name="gender" value="남"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					여자 : <input type="radio" name="gender" value="여"/>
				</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<th colspan="2">
					<button>회원가입</button>	
				</th>
			</tr>
		</table>		
	</form>
</body>
<script>
async function overlay(){
	//axios 는 라이브러리가 필요하다.
	let id = document.querySelector('input[name="id"]').value;
	const {data} = await axios.get('overlay.do?id='+id);
	console.log(data);	
	
	let msg = document.getElementById('msg');
	if(data.use){
		msg.innerHTML = '이미 사용중인 ID 입니다.';
		msg.style.color = 'red';
	}else{
		msg.innerHTML = '사용 가능한 ID 입니다.';
		msg.style.color = 'green';
	}	
}
</script>
</html>