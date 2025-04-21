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
      text-align: center;
    }

    th,td{
      padding: 10px;
    }

    th{
      width: 50px;
    }

    input[type=submit]{
      height: 67px;
    }
    </style>
</head>
<body>
  <h3>로그인 페이지</h3>
  <hr/>
  <form action="login.do" method="post">
  <table>
      <tr>
        <th>ID</th>
        <td><input type="text" name="id" placeholder="아이디를 입력 하세요"/></td>
        <th rowspan="2">
          <input type="submit" value="로그인"/></th>
      </tr>

      <tr>
        <th>PW</th>
        <td><input type="text" name="pw" placeholder="비밀번호를 입력 하세요"/></td>
      </tr>

      <tr>
        <th colspan="3">
          <input type="button" onclick="location.href='join.go'" value="회원가입"/>
          <input type="button" value="아이디/비번 찾기"/>
        </th>
      </tr>
  </table>
  </form>
</body>
<script>
	let msg = '${msg}';
	if (msg != '') {
		alert(msg);
	}
	
</script>
</html>