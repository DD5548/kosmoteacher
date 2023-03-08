<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
	<header>
		<h1>Survey Detail Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<%-- form start --%>

		<table class="table">
			<thead>
				<tr>
					<th colspan="2">SurveyDetail</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>항목</th>
					<th>투표수</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="e" items="${list }">
					<tr>
						<td>${e.num }</td>
						<td><a href="detailClient?num=${e.num }">${e.sub }</a></td>
						<td>${e.code }</td>
						<td>${e.surveytotal }</td>
						<td>${e.sdate }</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2"><input type="button" value="list"
						onclick="location='surveylist'"> <input type="button"
						value="delete" id="delete"></th>
				</tr>
			</tfoot>
		</table>
	</div>

</article>