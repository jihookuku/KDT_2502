<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="resources/img/favicon.ico">
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<title>Insert title here</title>
<style></style>
</head>
<body>
		<table>
		<tr>
			<th>제목</th>
			<td id="subject"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td id="userName"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td id="content"></td>
		</tr>
		<tr>
			<th>사진</th>
			<td>
				<div id="prev">없음</div>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="location.href='./list.go'">리스트</button>
			</th>
		</tr>
	</table>
</body>
<script>
	detailInfo('${idx}');
	
	 async function detailInfo(no){
		 
		 if(no == ''){
			 alert('불러올 수 없는 글번호 입니다.');
			 return false;
		 }		 
		 const data = await fetch('./detail.do?idx='+no);
		 const json = await data.json();
		 console.log(json);
		 
		 document.getElementById('subject').innerHTML = json.subject;
		 document.getElementById('userName').innerHTML = json.userName;
		 document.getElementById('content').innerHTML = json.content;
		 
		 if(json.photos.length>0){
			 content = '';
			 for(photo of json.photos){
				 content+='<img src="/photo/'+photo.newFileName+'" alt="'+photo.oriFileName+'"/>'
			 }
			 document.getElementById('prev').innerHTML = content;
		 } 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</script>
</html>