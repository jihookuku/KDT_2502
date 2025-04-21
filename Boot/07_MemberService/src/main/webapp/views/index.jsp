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
            padding: 10px;
        }
        input[type="submit"]{
            height: 67px;
        }
    </style>
</head>
<body>
    <h3>로그인</h3>
    <hr/>
    <form action="login" method="post">
    <table>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id"/> </td>
            <td rowspan="2">
                <input type="submit" value="로그인"/>
            </td>
        </tr>
        <tr>
            <th>PW</th>
            <td><input type="text" name="pw"/></td>
        </tr>
        <tr>
            <th colspan="3">
                <input type="button" onclick="location.href='joinForm'" value="회원가입"/>
                <input type="button" value="아이디/비번 찾기"/>
            </th>
        </tr>
    </table>
    </form>
</body>
<script>
	let msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
</script>
</html>









