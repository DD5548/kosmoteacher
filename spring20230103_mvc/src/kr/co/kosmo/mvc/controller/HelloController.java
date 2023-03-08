package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 생략 x
// HelloController는 예전에 모델에 해당이 된다.
// DispatcherServlet이란 콘트롤 사브릿이 스프링 콘테이나에 의해서 Model을 주입받아서 실행
// HandlerMapping이 요청 사항을 분석해준다. *****
@Controller // 생략 x
public class HelloController {
	// ActionFactory -> Spring container -> DispatcherServlet -> HandlerMapping이 분석
	@RequestMapping(value = "/hello")
	public ModelAndView myHello() {
		ModelAndView mav = new ModelAndView();
		// setAttribute
		mav.addObject("msg", "<h1>안녕하세요. 나의 첫번째 Spring MVC입니다.</h1>");
		// new ForwardAction
		mav.setViewName("hello");
		
		return mav;
	}
}
