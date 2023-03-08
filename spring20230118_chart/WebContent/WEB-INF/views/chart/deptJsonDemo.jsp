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
			<input type="text" name="id" id="id" placeholder="ID�� �Է��Ͻÿ�.">
			<hr>
			<button id="jsonAjaxTest">Click</button>
			<div id="target" class="row justify-content-center">Target!</div>
		</div>
	</div>
</article>
<script type="text/javascript">
	// jQuery ����
	$(function() {
		$('#jsonAjaxTest').click(function() {
			// alert('Test'+$('#deptno').val());
			$.ajaxSetup({ // Ajax ī�ø� ���� *
				cache: false
			});
			$.ajax({
				url: '../deptJsonView?id='+$('#id').val(),
				success: function(jsonData) {
					$('#target').html(''); // ����.
					console.log(jsonData);
					console.log(Object.keys(jsonData));
					console.log(Object.valueOf(jsonData));
					
					// json ����Ÿ�� jQuery �ݺ��ڸ� ����ؼ� ����ϱ�.
					$.each(jsonData, function(k, v) {
						console.log(k+': '+v);
						$('#target').append('<p>'+k+': '+v+'</p>');
					})
					// target�� �ڽ��� p Ÿ�׸� �����ؼ�
					// jQuery�� css �Լ��� ����ؼ� �������� css�� ������ �� �ִ�.
					$('#target>p').css('background', 'orange')
					.css('text-align', 'center')
					.css('color', '#fff');
				}
			});
		});
	});
</script>