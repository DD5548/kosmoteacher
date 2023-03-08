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
			<button id="jsonAjaxTest">Click</button>
			<div class="row justify-content-center">
				<table class="table">
					<thead>
						<tr>
							<td>Num</td>
							<td>Id</td>
							<td>Name</td>
							<td>Age</td>
							<td>Gender</td>
						</tr>
					</thead>
					<tbody id="target">
					
					</tbody>
				</table>
			</div>
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
				url: '../listJson',
				success: function(jsonData) {
					$('#target').html(''); // 비우기.
					
					console.log(jsonData);
					console.log(Object.keys(jsonData));
					console.log(Object.valueOf(jsonData));
					
					// json 데이타를 jQuery 반복자를 사용해서 출력하기.
					$.each(jsonData, function(k, v) {
						console.log(k+': '+v);
						
						$('#target').append('<tr>');
						$.each(v, function(k2, v2) {
							console.log(k2+': '+v2);
							
							if(v2 != null) {
								$('#target').append('<td>'+k2+': '+v2+'</td>');
							}
						})
						$('#target').append('</tr>');
					})
					// target의 자식인 p 타그를 선택해서
					// jQuery의 css 함수를 사용해서 동적으로 css를 적용할 수 있다.
					$('#target>td').css('background', 'orange')
					.css('color', '#fff');
				}
			});
		});
	});
</script>