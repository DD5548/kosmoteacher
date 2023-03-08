<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

</head>
<body>
<!-- 1 page -->
<div data-role="page">

	<div data-role="header">
		<h1>Mobile page</h1>
		<a href="" class="ui-btn ui-btn-inline">Home</a>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<p>UploadDemo mobile page list</p>
		<div data-role="collapsible" data-mini="true">
			<h3>List</h3>
			<ul data-role="listview">
			<c:forEach var="e" items="${list }">
				<li>
					<a><img ismap src="${pageContext.request.contextPath }/resources/imgfile/${e.imgn}"></a>
					<h3>${e.sub }</h3>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Footer content</h4>
	</div><!-- /footer -->

</div><!-- /1 page -->
</body>
</html>