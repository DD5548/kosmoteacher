<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p>회원가입 축하</p>
	<hr>
	<h2>회원의 정보 확인</h2>
	<table style="width: 80%; margin: auto;">
			<tr>
				<td>ID</td>
				<td>P/W</td>
				<td>Name</td>
			</tr>
			<tr>
				<td>${vo.id }</td>
				<td>${vo.pw }</td>
				<td>${vo.uname }</td>
			</tr>
		</table>
</body>
</html>