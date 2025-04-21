<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table, th, td{
            border: 1px solid black;
            border-collapse: collapse;
        }
        th{
            padding: 10px 25px;
        }
        td{
            padding: 10px 5px;
        }

        input[type="text"], input[type="password"], input[type="email"], input[type="range"]{
            width: 95%;
        }
    </style>
</head>
<body>
    <h3>회원가입 페이지</h3>
    <hr/>
    <form action="join" method="post">
    <table>
        <tr>
            <th>아이디</th>
            <td>
            	<input type="text" name="id"/>
            	<input type="button" value="중복아이디 확인" onclick="overlayChk()"/>
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pw"/></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="email" name="email"/> </td>
        </tr>
        <tr>
            <th>성별</th>
            <td>
                <input type="radio" name="gender" value="남자"/> 남자
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="gender" value="여자"/>여자
            </td>
        </tr>
        <tr>
            <th>나이</th>
            <td><input type="number" min="20" max="80" name="age"/> </td>
        </tr>
        <tr>
        	<th colspan = "2">
        		<button>회원가입</button>
        	</th>
        </tr>
    </table>
    </form>
</body>
<script>
async function overlayChk(){
	let elem = document.querySelector('input[name="id"]');
	
	const resp = await fetch('overlay.ajax?id='+elem.value);
	const data = await resp.json();
	console.log(data);
	if(data.cnt>0){
		alert(elem.value+' 는 사용중인 아이디 입니다.');
		elem.value='';
	}else{
		alert(elem.value+' 는 사용 가능한 아이디 입니다.');
	}	
}
</script>
</html>























