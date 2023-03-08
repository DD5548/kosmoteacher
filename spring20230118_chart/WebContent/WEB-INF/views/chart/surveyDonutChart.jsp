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
		// ��� �� json�� �Ľ��� ����Ÿ
		let jsondata = {
			'�� �ɴϴ�' : 500,
			'�ȿɴϴ�' : 200,
			'�𸨴ϴ�' : 666,
			'��ǳ�� �ɴϴ�' : 54,
			'���ɾ���' : 120
		}
		console.log(jsondata);
		var chart = c3.generate({
			<%--
				data: {
			        columns: [
			            ['�� �ɴϴ�', 500],
			            ['�ȿɴϴ�', 200],
			            ['�𸨴ϴ�', 666],
			            ['��ǳ�� �ɴϴ�', 54],
			            ['���� ����', 120],
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
				title : "���� �������系��"
			}
		});
	</script>
</body>
</html>