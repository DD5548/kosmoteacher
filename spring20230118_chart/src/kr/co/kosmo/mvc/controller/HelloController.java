package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// ���� x
// HelloController�� ������ �𵨿� �ش��� �ȴ�.
// DispatcherServlet�̶� ��Ʈ�� ��긴�� ������ �����̳��� ���ؼ� Model�� ���Թ޾Ƽ� ����
// HandlerMapping�� ��û ������ �м����ش�. *****
@Controller // ���� x
public class HelloController {
	// ActionFactory -> Spring container -> DispatcherServlet -> HandlerMapping�� �м�
	@RequestMapping(value = "/hello")
	public ModelAndView myHello() {
		ModelAndView mav = new ModelAndView();
		// setAttribute
		mav.addObject("msg", "<h1>�ȳ��ϼ���. ���� ù��° Spring MVC�Դϴ�.</h1>");
		// new ForwardAction
		mav.setViewName("hello");
		
		return mav;
	}
}
