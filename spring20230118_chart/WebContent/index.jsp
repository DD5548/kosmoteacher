<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>KOSMO</title>
</head>
<body>
	<script type="text/javascript">
		function checkDevice() {
			// javascript ����
			// javascript: ũ���̿�Ʈ���� �ؼ��ȴ� ��Ÿ����Ÿ ����̰�, ��ü ���� ����̴�.
			// �����ڸ��� ������ �ٸ��� ������ �ణ�� �Ľ���  ���̰� ���� �� �ִ�.
			// HTML 5�������� ǥ��ȭ�� ���� -> ECMA 5 ~ 7 �ø���
			// ���� ������ var, let���� �Ѵ�.
			var userAgent = navigator.userAgent.toLowerCase();
			alert(userAgent);
			console.log("userAgent: " + userAgent);
			// var platform = navigator.platform.toLowerCase();
			// console.log("platform: "+platform);
			// indexOf() -> ã�� ���ϸ� -1
			console.log("indexOf() -> " + userAgent.indexOf('android'));
			if (userAgent.indexOf('android') > -1
					|| userAgent.indexOf('iphone') > -1) {
				console.log('mobile');
				// location = '�̵��� url'
				location = 'mobile/';
			} else {
				console.log("PC");
				// location = "web/";
			}
		}
	</script>
</body>
</html>