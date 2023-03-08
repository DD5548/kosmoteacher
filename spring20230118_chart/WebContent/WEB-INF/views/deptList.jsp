<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>deptList</title>
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
		<h1>ResultMap 예제 2</h1>
		<h2>== Code Here ==</h2>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>직책</th>
					<th>이름</th>
					<th>사원급여</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${dvo.sawon }">
					<tr>
						<th>${dvo.deptno }</th>
						<th>${e.sajob }</th>
						<th>${e.saname }</th>
						<th>${e.sapay }</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>