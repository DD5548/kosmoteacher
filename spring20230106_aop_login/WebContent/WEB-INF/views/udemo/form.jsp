<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>

<article>
	<header>
		<h1>FileUpload Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%-- boardForm 들어 갈 자리. --%>
		<fieldset>
			<legend>이미지 업로드 폼</legend>
			<form method="post" action="uploadpro" enctype="multipart/form-data">
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">제 목</label>
					<div class="col-sm-10">
						<input type="text" name="sub" id="sub" placeholder="제목을 입력하세요." />
					</div>

				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">작성자</label>
					<div class="col-sm-10">
						<input type="text" name="writer" id="writer" />
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="pw" id="pw" />
					</div>
				</div>
				<div class="row mb-3">
					<textarea name="cont" id="cont" rows="10" cols="13"></textarea>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">*이미지업로드</label>
					<div class="col-sm-10">
						<input type="file" name="mfile" id="mfile" />
					</div>
					<div class="col-sm-10">
						<img src="../resources/image/noimage.jpg" id="imgx">
					</div>
				</div>
				<div class="row mb-3 ">
					<div class="col-sm-10">
						<input type="submit" value="등록" id="btn1" class="btn btn-info" />
						<input type="button" value="리스트" id="listBtn"
							class="btn btn-danger" />
					</div>
				</div>
			</form>
		</fieldset>
	</div>
</article>
<%@include file="../temp/footer.jsp"%>

<script>
	//javascript는 클라이언트 측 언어
	//HTML, CSS를 동적으로 제어하는 목적으로 주로 사용
	//html5부터 제공해주는 FileReader()함수를 사용해서 이미지 미리보기를 구현
	//함수는 메서드와 비슷
	/*
	 * public viod readURL(String input){ }
	 */
	function readURL(input) {
		//input type="file" 의 주소를 가져온다
		if (input.files && input.files[0]) {
			//자바스크립트 I/O
			var reader = new FileReader();
			//감지자
			reader.onload = function(e) { //onload : 이벤트(감지)
				console.log("Path: " + e.target.result);
				//이미지를 id로 선택해보자
				//$('#imgx') => <img src="이미지경로" id="imgx"
				//console.log($('#imgx').attr('src'));
				$('#imgx').attr('src', e.target.result);
			}
			//input type="file"의 값을 바이너리 데이터로 읽어온다
			reader.readAsDataURL(input.files[0]);
		}
	}

	// JQuery 문법
	$(function() {
		// JQuery 선택자
		// 대상 선택자에서 변화를 감지하는 이벤트: change()
		$('#mfile').change(function() {
			// alert
			alert("경고창");
			// alert($(this).val());
			// console
			// console.log($(this).val());
			// console.log($(this).val().length);
			// 브라우자 콘솔 창에 출력
			if ($(this).val().length > 0) {
				console.log("이미지 있다.");
				// 함수 호출
				readURL(this);
			} else {
				console.log("이미지 없다.");
			}
		});

		// 리스트 바톤 크릭
		// wtn 바톤 크릭 이벤트
		$('#listBtn').click(function() {
			// 이동
			location = "ex2_ListForm.jsp";
		});
	});
</script>