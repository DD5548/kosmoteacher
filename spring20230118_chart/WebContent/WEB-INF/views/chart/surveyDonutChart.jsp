<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--2023. 1. 17. / kosmo --%>
<!-- file_name -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ex5_customJsonStudent.jsp</title>
<%--load c3.css --%>
<link href="../resources/css/c3.css" rel="stylesheet">
<style></style>
<!-- Load d3.js and c3.js -->
<script src="../resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="../resources/js/c3.min.js"></script>
</head>
<body>
	<div id="chart"></div>
	<script>
		// 사바 측 json을 파싱한 데이타
		let jsondata = {
			'비가 옵니다' : 500,
			'안옵니다' : 200,
			'모릅니다' : 666,
			'태풍이 옵니다' : 54,
			'관심없음' : 120
		}
		console.log(jsondata);
		var chart = c3.generate({
			<%--
				data: {
			        columns: [
			            ['비가 옵니다', 500],
			            ['안옵니다', 200],
			            ['모릅니다', 666],
			            ['태풍이 옵니다', 54],
			            ['관심 없음', 120],
			        ],
			        type : 'donut',
			    }
			 --%>
			bindto : '#chart',
			data : {
				json : [ jsondata ],
				keys : {
					value : Object.keys(jsondata),
				},
				type : 'donut'
			},
			donut : {
				title : "날씨 설문조사내용"
			}
		});
	</script>
</body>
</html>