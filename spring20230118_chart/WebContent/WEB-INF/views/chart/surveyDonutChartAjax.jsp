<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<article>
	<header>
		<h1>[ChartJson Demo]surveyChart.js</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<div id="chart"></div>

	</div>

</article>
<script>
/*
var jsondata = {
		'�� �ɴϴ�': 500,
		'�ȿɴϴ�': 200,
		'�𸨴ϴ�': 666,
		'��ǳ�̿ɴϴ�': 54,
		'���ɾ���': 120
		};
*/
<%--
data : {
	json : [ jsondata ],
	keys : {
		value : Object.keys(jsondata),
	},
	type : 'donut'
}
--%>

$.ajaxSetup({
	cache : false
});
$.ajax({
	url : "../surveyJsonObj2?num=41",
	success : function(jsondata) {
		console.log(jsondata);
		
		var chart = c3.generate({
			bindto : '#chart',
			data : {
				json : [ jsondata[1] ],
				keys : {
					value : Object.keys(jsondata),
				},
				type : 'donut'
			},
			donut : {
				title : "���� ������ ���� �ͳ���?",
			},
		});
		//----------------------
	},
	error : function(e) {
		console.log("error:" + e);
	}
});
</script>