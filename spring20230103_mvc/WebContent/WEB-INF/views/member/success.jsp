<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p>ȸ������ ����</p>
	<hr>
	<h2>ȸ���� ���� Ȯ��</h2>
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