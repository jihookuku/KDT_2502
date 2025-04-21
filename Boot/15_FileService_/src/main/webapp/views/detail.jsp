<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        input text{
            text-align: left;
        }

        input[type=text], input[type=password] , input[type=email], input[type=range]{
            width: 96%;
        }

    </style>
</head>
<body>
	<div>안녕하세요 ${sessionScope.loginId} 님
		<a href="logout">로그아웃</a>
	</div>
    <h3>${info.name} 회원 상세 보기</h3>
    <hr/>
    <table>
        <thead>
        <tr>
            <th>아이디</th>
            <td>${info.id}</td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>${info.pw}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${info.name}</td>
        </tr>
        <tr>
            <th>이메일</th>
            <td>${info.email}</td>
        </tr>
        <tr>
            <th>성별</th>
            <td>${info.gender}</td>
        </tr>
        <tr>
            <th>나이</th>
            <td>${info.age}</td>
        </tr>
        <tr>
        	<th colspan="2">
        		<button onclick="location.href='list'">리스트</button>
        		<button onclick="location.href='updateForm?id=${info.id}'">수정</button>
        	</th>
        </tr>
        </thead>
    </table>
</body>
</html>