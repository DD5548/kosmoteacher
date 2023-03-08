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
		'비가 옵니다': 500,
		'안옵니다': 200,
		'모릅니다': 666,
		'태풍이옵니다': 54,
		'관심없음': 120
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
				title : "어디로 여행을 가고 싶나요?",
			},
		});
		//----------------------
	},
	error : function(e) {
		console.log("error:" + e);
	}
});
</script>