<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex flex-row-reverse mybgColor">
	<div class="p-2 bg-info">
		<a href="#" class="nav-link text-white" id="item1">Flex item 1</a>
	</div>
	<c:choose>
		<c:when test="${sessionScope.sessionID == null }">
			<div class="p-2 bg-warning">
				<a href="${pageContext.request.contextPath}/login/form"
					class="nav-link text-white" id="item2">Login</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="p-2 bg-warning">
				<a href="${pageContext.request.contextPath}/login/logout"
					class="nav-link text-white" id="item2">Logout</a>
			</div>
		</c:otherwise>
	</c:choose>
	<div class="p-2 bg-primary">
		<a href="${pageContext.request.contextPath}/member/memberForm"
			class="nav-link text-white" id="item3">회원가입</a>
	</div>
</div>