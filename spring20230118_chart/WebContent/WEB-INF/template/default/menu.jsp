<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-sm mybgColor">
	<div class="container-fluid">
		<ul class="navbar-nav">
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/main"
				class="nav-link active">Home</a></li>
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/board/list"
				class="nav-link">Board</a></li>
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/upload/form"
				class="nav-link">Upload</a></li>
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/mail/form"
				class="nav-link">Email</a></li>
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/survey/form"
				class="nav-link">Survey</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" role="button"
				data-bs-toggle="dropdown" aria-expanded="false"> Chart </a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/studentChart">studentChart</a></li>
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/surveyDonutChart">surveyDonutChart</a></li>
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/deptJsonDemo">deptJsonDemo</a></li>
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/memberJsonDemo">memberJsonDemo</a></li>
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/surveyDonutChartAjax">surveyDonutChartAjax</a></li>
				</ul></li>
		</ul>
		<form class="d-flex">
			<input class="form-control me-2" type="text" placeholder="Search"
				name="searchv" id="searchv">
			<button class="btn btn-primary" type="button">Search</button>
		</form>
	</div>
</nav>