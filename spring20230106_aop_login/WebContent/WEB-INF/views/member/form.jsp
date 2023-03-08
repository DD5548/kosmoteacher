<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="insertMember" method="post">
		<table style="width: 80%; margin: auto;">
			<tr>
				<td>ID</td>
				<td>
					<input type="text" name="id" maxlength="10" style="width: 130px">
					<input type="button" id="idChkBtn" value="중복 확인" style="width: 150px; font-size: 10px; height: 30px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" id="target"></td>
			</tr>
			<tr>
				<td>P/W</td>
				<td><input type="password" name="pw" maxlength="10"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Join"></td>
			</tr>
		</table>
	</form>
</body>
</html>