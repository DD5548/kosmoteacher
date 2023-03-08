package kr.co.kosmo.mvc.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamDemoController {
	
	// @RequestParam 전달되어 오는 파라미타를 체크할 때 사용한다.
	// 속성: value로 정해진 id 즉 파라미타 이름으로 받을 수 있다. *
	@RequestMapping(value = "/reqparam", method = RequestMethod.GET)
	public ModelAndView paramDemo(@RequestParam("id") String code) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", code);
		mav.setViewName("mytest/testview");
		System.out.println("code -> "+code);
		
		return mav;
	}
	// required = false: 파라미타 값에 대한 예외를 발생하지 않는다.
	// defaultValue = "": 파라미타 값이 없을 때 기본값으로 설정
	@RequestMapping(value = "/reqparam2", method = RequestMethod.GET)
	public ModelAndView paramDemo2(@RequestParam(value = "id", required = false, defaultValue = "x man") String code) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", code);
		mav.setViewName("mytest/testview");
		System.out.println("code -> "+code);
		
		return mav;
	}
}
