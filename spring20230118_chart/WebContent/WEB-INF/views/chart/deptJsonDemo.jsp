<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<article>
	<header>
		<h1>deptJsonDemo.jsp</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<div class="row">
			<input type="text" name="id" id="id" placeholder="ID를 입력하시오.">
			<hr>
			<button id="jsonAjaxTest">Click</button>
			<div id="target" class="row justify-content-center">Target!</div>
		</div>
	</div>
</article>
<script type="text/javascript">
	// jQuery 시작
	$(function() {
		$('#jsonAjaxTest').click(function() {
			// alert('Test'+$('#deptno').val());
			$.ajaxSetup({ // Ajax 카시를 삭제 *
				cache: false
			});
			$.ajax({
				url: '../deptJsonView?id='+$('#id').val(),
				success: function(jsonData) {
					$('#target').html(''); // 비우기.
					console.log(jsonData);
					console.log(Object.keys(jsonData));
					console.log(Object.valueOf(jsonData));
					
					// json 데이타를 jQuery 반복자를 사용해서 출력하기.
					$.each(jsonData, function(k, v) {
						console.log(k+': '+v);
						$('#target').append('<p>'+k+': '+v+'</p>');
					})
					// target의 자식인 p 타그를 선택해서
					// jQuery의 css 함수를 사용해서 동적으로 css를 적용할 수 있다.
					$('#target>p').css('background', 'orange')
					.css('text-align', 'center')
					.css('color', '#fff');
				}
			});
		});
	});
</script>