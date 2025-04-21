<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
</head>
<body>
<a href="photoList">사진리스트</a>

<h3>단일 파일 업로드</h3>
<!-- 파일을 서버로 제대로 보내는 방법 
	1. method 는 POST 로 보내야 한다.
	2. enctype 에 문자 말고 다른것도 폼으로 보낸다고 알려줘야 한다.
-->
<form action="upload" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadFile"/>
	<button>전송</button>
</form>

<h3>여러 파일 업로드</h3>
<form action="multiUpload" method="post" enctype="multipart/form-data">
	<input type="file" name="files" multiple="multiple"/>
	<button>전송</button>
</form>

</body>
<script></script>
</html>