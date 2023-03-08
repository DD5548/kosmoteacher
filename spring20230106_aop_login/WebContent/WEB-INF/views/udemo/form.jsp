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
		<%-- boardForm ��� �� �ڸ�. --%>
		<fieldset>
			<legend>�̹��� ���ε� ��</legend>
			<form method="post" action="uploadpro" enctype="multipart/form-data">
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">�� ��</label>
					<div class="col-sm-10">
						<input type="text" name="sub" id="sub" placeholder="������ �Է��ϼ���." />
					</div>

				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">�ۼ���</label>
					<div class="col-sm-10">
						<input type="text" name="writer" id="writer" />
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">��й�ȣ</label>
					<div class="col-sm-10">
						<input type="password" name="pw" id="pw" />
					</div>
				</div>
				<div class="row mb-3">
					<textarea name="cont" id="cont" rows="10" cols="13"></textarea>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">*�̹������ε�</label>
					<div class="col-sm-10">
						<input type="file" name="mfile" id="mfile" />
					</div>
					<div class="col-sm-10">
						<img src="../resources/image/noimage.jpg" id="imgx">
					</div>
				</div>
				<div class="row mb-3 ">
					<div class="col-sm-10">
						<input type="submit" value="���" id="btn1" class="btn btn-info" />
						<input type="button" value="����Ʈ" id="listBtn"
							class="btn btn-danger" />
					</div>
				</div>
			</form>
		</fieldset>
	</div>
</article>
<%@include file="../temp/footer.jsp"%>

<script>
	//javascript�� Ŭ���̾�Ʈ �� ���
	//HTML, CSS�� �������� �����ϴ� �������� �ַ� ���
	//html5���� �������ִ� FileReader()�Լ��� ����ؼ� �̹��� �̸����⸦ ����
	//�Լ��� �޼���� ���
	/*
	 * public viod readURL(String input){ }
	 */
	function readURL(input) {
		//input type="file" �� �ּҸ� �����´�
		if (input.files && input.files[0]) {
			//�ڹٽ�ũ��Ʈ I/O
			var reader = new FileReader();
			//������
			reader.onload = function(e) { //onload : �̺�Ʈ(����)
				console.log("Path: " + e.target.result);
				//�̹����� id�� �����غ���
				//$('#imgx') => <img src="�̹������" id="imgx"
				//console.log($('#imgx').attr('src'));
				$('#imgx').attr('src', e.target.result);
			}
			//input type="file"�� ���� ���̳ʸ� �����ͷ� �о�´�
			reader.readAsDataURL(input.files[0]);
		}
	}

	// JQuery ����
	$(function() {
		// JQuery ������
		// ��� �����ڿ��� ��ȭ�� �����ϴ� �̺�Ʈ: change()
		$('#mfile').change(function() {
			// alert
			alert("���â");
			// alert($(this).val());
			// console
			// console.log($(this).val());
			// console.log($(this).val().length);
			// ������ �ܼ� â�� ���
			if ($(this).val().length > 0) {
				console.log("�̹��� �ִ�.");
				// �Լ� ȣ��
				readURL(this);
			} else {
				console.log("�̹��� ����.");
			}
		});

		// ����Ʈ ���� ũ��
		// wtn ���� ũ�� �̺�Ʈ
		$('#listBtn').click(function() {
			// �̵�
			location = "ex2_ListForm.jsp";
		});
	});
</script>