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
			// javascript 영역
			// javascript: 크라이엔트에서 해석된느 인타프리타 언어이고, 객체 지향 언어이다.
			// 브라우자마다 엔진이 다르기 때문에 약간의 파싱의  차이가 있을 수 있다.
			// HTML 5에서부터 표준화된 바존 -> ECMA 5 ~ 7 시리즈
			// 변수 선언은 var, let으로 한다.
			var userAgent = navigator.userAgent.toLowerCase();
			alert(userAgent);
			console.log("userAgent: " + userAgent);
			// var platform = navigator.platform.toLowerCase();
			// console.log("platform: "+platform);
			// indexOf() -> 찾지 못하면 -1
			console.log("indexOf() -> " + userAgent.indexOf('android'));
			if (userAgent.indexOf('android') > -1
					|| userAgent.indexOf('iphone') > -1) {
				console.log('mobile');
				// location = '이동할 url'
				location = 'mobile/';
			} else {
				console.log("PC");
				// location = "web/";
			}
		}
	</script>
</body>
</html>