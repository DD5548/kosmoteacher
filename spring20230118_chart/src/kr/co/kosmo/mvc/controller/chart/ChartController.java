package kr.co.kosmo.mvc.controller.chart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chart")
public class ChartController {
	@GetMapping(value = "/studentChart")
	public String ex5_customStudent() {
		return "chart/studentChart";
	}
	@GetMapping(value = "/surveyDonutChart")
	public String ex6_DonutChart() {
		return "chart/surveyDonutChart";
	}
	@GetMapping(value = "/deptJsonDemo")
	public String deptJsonDemo() {
		return "chart/deptJsonDemo";
	}
	@GetMapping(value = "/memberJsonDemo")
	public String memberJsonDemo() {
		return "chart/memberJsonDemo";
	}
	@GetMapping(value = "/surveyDonutChartAjax")
	public String chart3() {
		return "chart/surveyDonutChartAjax";
	}
}
