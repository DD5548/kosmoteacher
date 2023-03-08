<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="demo" class="carousel slide" data-bs-ride="carousel">
			<!-- Indicators/dots -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#demo" data-bs-slide-to="0"
					class="active"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
			</div>

			<!-- The slideshow/carousel -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="${pageContext.request.contextPath}/resources/image/d1.jpg"
						alt="Kosmo113" class="d-block" style="width: 100%">
					<div class="carousel-caption">
						<h3>UI 요구사항 확인하기,UI 설계하기</h3>
						<p>jQuery 를 이용하여 제공받은 샘플파일에서 아래 요구사항대로 구현합니다.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/image/d2.jpg"
						alt="Carousel" class="d-block" style="width: 100%">
					<div class="carousel-caption">
						<h3>Carousel 기능을 CSS3로!</h3>
						<p>
							<c:choose>
								<c:when test="${sessionScope.sessionName != null }">
        			${sessionScope.sessionName }님 반가워요. 오늘 날씨가 너무  좋네요.
        		</c:when>
								<c:otherwise>
        			Thank, CSS3!
        		</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div>
				<div class="carousel-item">
					<%-- image를 세숀 값에 따라 변경해보는 데모! --%>
					<c:choose>
						<c:when test="${sessionScope.sessionName == null }">
							<c:set var="imgv3" value="d3.jpg" scope="page" />
						</c:when>
						<c:otherwise>
							<c:set var="imgv3" value="myd1.png" scope="page" />
						</c:otherwise>
					</c:choose>
					<img
						src="${pageContext.request.contextPath}/resources/image/${imgv3 }"
						alt="JSP" class="d-block" style="width: 100%">
					<div class="carousel-caption">
						<h3>UI 요구사항 확인하기,UI 설계하기</h3>
						<p>
							<%-- text를 세숀 값에 따라 변경해보는 데모! --%>
							<c:choose>
								<c:when test="${sessionScope.sessionName != null }">
        			${sessionScope.sessionName }님 반가워요. 당신이 좋아하는 선물은?
        		</c:when>
								<c:otherwise>
        			오늘의 날씨 같은 거 출력해주면 어떨까요?
        		</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div>
			</div>

			<!-- Left and right controls/icons -->
			<button class="carousel-control-prev" type="button"
				data-bs-target="#demo" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#demo" data-bs-slide="next">
				<span class="carousel-control-next-icon"></span>
			</button>
		</div>