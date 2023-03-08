package kr.co.kosmo.mvc.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamDemoController {
	
	// @RequestParam ���޵Ǿ� ���� �Ķ��Ÿ�� üũ�� �� ����Ѵ�.
	// �Ӽ�: value�� ������ id �� �Ķ��Ÿ �̸����� ���� �� �ִ�. *
	@RequestMapping(value = "/reqparam", method = RequestMethod.GET)
	public ModelAndView paramDemo(@RequestParam("id") String code) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", code);
		mav.setViewName("mytest/testview");
		System.out.println("code -> "+code);
		
		return mav;
	}
	// required = false: �Ķ��Ÿ ���� ���� ���ܸ� �߻����� �ʴ´�.
	// defaultValue = "": �Ķ��Ÿ ���� ���� �� �⺻������ ����
	@RequestMapping(value = "/reqparam2", method = RequestMethod.GET)
	public ModelAndView paramDemo2(@RequestParam(value = "id", required = false, defaultValue = "x man") String code) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", code);
		mav.setViewName("mytest/testview");
		System.out.println("code -> "+code);
		
		return mav;
	}
}
