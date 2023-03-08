package kr.co.kosmo.mvc.controller.chart;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@RestController
public class SurveyRestController {
	@Autowired
	private SurveyService service;

	/*
	 * {"num":41,"code":3,"surveytotal":1366,"sub":"a","sdate":"2023-01-18 15:04:31",
	 * 	"subvey":[{"subcode":41,"surveycnt":500,"subtype":"A","surveytitle":"a"},
	 * 		{"subcode":41,"surveycnt":200,"subtype":"B","surveytitle":"b"},
	 * 		{"subcode":41,"surveycnt":666,"subtype":"C","surveytitle":"c"}]}
	 */
	@RequestMapping(value = "/surveyJsonObj", produces = "application/json;charset=utf-8")
	public Map<String, Integer> detail(int num) {
		SurveyVO vo = service.detail(num);
		// Key, Val -> Map
		Map<String, Integer> map = new HashedMap();
		for (SurveyContentVO e : vo.getSubvey()) {
			// 'a': 500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		return map;
	}
	// Map으로 반환한 json 데이타와 title을 함께 보내기.
	@RequestMapping(value = "/surveyJsonObj2", produces = "application/json;charset=utf-8")
	public String detailContent(int num) {
		SurveyVO vo = service.detail(num);
		// Key, Val -> Map
		Map<String, Integer> map = new HashMap<>();
		for (SurveyContentVO e : vo.getSubvey()) {
			// 'a': 500,
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		// json 결과를 문자열로 반환
		String result = null;
		// ObjectMapper 객체를 가지고 변환을 할 수 있다.
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			result = mapper.writeValueAsString(map);
			// [{"sub"="a"}, map]
			result = "[{\"sub\"=\""+vo.getSub()+"\"}, "+result+"]"; // [{"sub"="a"}, {"a":0,"c":0,"b":0}]
			System.out.println(result);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}
}
