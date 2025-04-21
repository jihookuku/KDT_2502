<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
}

input text {
	text-align: left;
}

input[type=text], input[type=password], input[type=email], input[type=range]
	{
	width: 96%;
}
</style>
</head>
<body>
	<h3>회원가입 페이지</h3>
	<hr />
	<form action="join.do" method="post">
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" /> <input type="button"
						value="중복 아이디 확인" onclick="overlayChk()" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" /></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="gender" value="남자" />남자
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="gender"
						value="여자" />여자</td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" min="20" max="80" name="age"
						value="20" /></td>
				</tr>
				<tr>
					<th colspan="2">
						<button type="button" onclick="join()">회원가입</button>
					</th>
				</tr>
			</thead>
		</table>
	</form>
</body>
<script>
	let chk = false;

	async function overlayChk() {
		let elem = document.querySelector('input[name="id"]');

		if(elem.value == ''){
			alert('아이디를 입력하세요');
			return false;	
		}
		const resp = await
		fetch('overlay.ajax?id=' + elem.value);
		const data = await
		resp.json();
		console.log(data);
		if (data.cnt > 0) {
			alert(elem.value + '는 사용중인 아이디 입니다.');
			elem.value = '';
		} else {
			alert(elem.value + '는 사용 가능한 아이디 입니다.');
			chk=true;
		}
	}

	function join() {
		let id = document.querySelector('input[name="id"]');
		let pw = document.querySelector('input[name="pw"]');
		let name = document.querySelector('input[name="name"]');
		let email = document.querySelector('input[name="email"]');
		let gender = document.querySelector('input[name="gender"]:checked');
		let age = document.querySelector('input[name="age"]');

		if (id.value == '') {
			alert('아이디를 입력하세요');
			id.focus();
		} else if (pw.value == '') {
			alert('비밀번호를 입력하세요');
			pw.focus();
		} else if (name.value == '') {
			alert('이름을 입력하세요');
			name.focus();
		} else if (email.value == '') {
			alert('이메일을 입력하세요');
			email.focus();
		} else if (gender == null) {
			alert('성별을 선택해주세요');
			document.querySelector('input[name="gender"]').checked=true;
		} else if (age.value == '') {
			alert('나이를 입력하세요');
			age.focus();
		} else if (chk == false) {
			alert('아이디 중복체크를 실행해주세요');
		} else { 
			// 서버에 전송
			document.querySelector('form').submit();
		}
	
		}
</script>
</html>