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
	<div>
		안녕하세요 ${sessionScope.loginId} 님 
		<a href="logout">로그아웃</a>
	</div>
    <h3>${info.name} 회원 정보 변경</h3>
    <hr/>
    <form action="update" method="post">
    <table>
        <tr>
            <th>아이디</th>
            <td>
            ${info.id}
            <input type="hidden" name="id" value="${info.id}"/>
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pw" value="${info.pw}"/></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="${info.name}"/></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="email" name="email" value="${info.email}"/></td>
        </tr>
        <tr>
            <th>성별</th>
            <td>
                <input type="radio" name="gender" value="남" 
                <c:if test="${info.gender eq '남'}">checked</c:if>                
                /> 남자
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="gender" value="여" 
                <c:if test="${info.gender eq '여'}">checked</c:if>
                />여자
            </td>
        </tr>
        <tr>
            <th>나이</th>
            <td>
            	<input type="number" min="20" max="80" name="age" 
            		value="${info.age}"/>
            </td>
        </tr>
        <tr>
        	<th colspan = "2">
        		<button>저장</button>
        	</th>
        </tr>
    </table>
    </form>
</body>
</html>