<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>sawonPhoneList</title>
<style>
#container {
	width: 650px;
	margin: auto;
}

table {
	border-collapse: collapse;
	width: 100%
}

th {
	background-color: #c0c0c0
}

tbody img {
	width: 100px;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background: #f5f5f5
}
</style>
</head>
<body>
	<div id="container">
		<h1>ResultMap 예제 1</h1>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>직책</th>
					<th>이름</th>
					<th>폰번호</th>
					<th>폰모델</th>
					<th>지급날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${slist }">
					<tr>
						<th>${e.sabun }</th>
						<th>${e.sajob }</th>
						<th>${e.saname }</th>
						<th>${e.spvo.phnum }</th>
						<th>${e.spvo.pmodel }</th>
						<th>${e.spvo.pdate }</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>