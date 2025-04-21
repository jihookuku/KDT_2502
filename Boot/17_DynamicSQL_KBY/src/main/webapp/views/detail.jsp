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

		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" value="${dto.id}" readonly="readonly"/></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" value="${dto.pw}"/></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${dto.name}"/></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email"  value="${dto.email}"/></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="남자" 
						<c:if test="${dto.gender eq '남자' }">checked</c:if>
						/>남자
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="radio" name="gender"	value="여자" 
						<c:if test="${dto.gender eq '여자' }">checked</c:if>
						/>여자
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" min="20" max="80" name="age"
						value="${dto.age}" /></td>
				</tr>
				<tr>
					<th colspan="2">
						<button onclick="update()">수정</button>
					</th>
				</tr>
			</thead>
		</table>
</body>
<script>
// 변경한 값만 수정할 예정
async function update(){

	const param = {id:'${dto.id}'};
	const inputs = document.querySelectorAll('table input');
		
	for(input of inputs){
		//console.log([input]);// 이전값 현재값
		if(input.type=='radio'){			
			if(input.checked != input.defaultChecked && input.checked == true){// 라디오의 경우 체크되어 있다면...
				param[input.name]  = input.value;
			}			
		}else{
			if(input.value != input.defaultValue){
				param[input.name]  = input.value;
			}			
		}		
	}	
	console.log(param);
	
	// 비동기 방식, post 메서드로 전송
	const resp = await fetch('update.ajax',{
		method:'POST',
		headers:{
			'Content-Type':'application/json'
		},
		body:JSON.stringify(param)
	});
	
	const json = await resp.json();
	console.log(json);
	
	if(json.success > 0){
		alert('정보 수정에 성공 했습니다.');
	}else{
		alert('정보 수정에 실패 했습니다.');
	}
	location.reload();//새로고침
	
	
}
</script>
















</html>