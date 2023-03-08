package kr.co.kosmo.mvc.controller.survey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private SurveyService service;

	@GetMapping(value = "/form")
	public String form() {
		return "survey/form";
	}

	@PostMapping(value = "/insert")
	public String insert(SurveyVO vo, HttpServletRequest request) {
		// 같은 이름으로 넘어오는 파라미타는 배열로 받을 수 있다.
		String[] surveytitle = request.getParameterValues("surveytitle");
		char stype = 'A';

		// DB에 전달하기 위한 List 만들기.
		List<SurveyContentVO> list = new ArrayList<SurveyContentVO>();

		for (String e : surveytitle) {
			SurveyContentVO scvo = new SurveyContentVO();

			System.out.println("surveytitle -> " + e);

			scvo.setSurveytitle(e);
			scvo.setSurveycnt(0);
			scvo.setSubtype(String.valueOf(stype));

			list.add(scvo);
			
			stype++; // 알파벳을 증가
		}

		System.out.println("Sub -> " + vo.getSub());

		// SurveyVO에 설문 타이틀을 저장한 List<SurveyContentVO> 인자로 전달
		vo.setSubvey(list);

		// Service에 값을 전달한다.
		service.insert(vo, list);

		return "redirect:list";
	}

	@GetMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("survey/surveyList");
		List<SurveyVO> list = service.list();
		
		mav.addObject("list", list);
		
		return mav;
	}
	@RequestMapping(value = "/detail")
	public ModelAndView detail(int num) {
		ModelAndView mav = new ModelAndView("survey/detail");
		SurveyVO vo = service.detail(num);
		mav.addObject("vo", vo);
		
		return mav;
	}
	@GetMapping(value = "/detailClient")
	public ModelAndView detailClient(int num) {
		ModelAndView mav = new ModelAndView("survey/clientDetail");
		SurveyVO vo = service.detail(num);
		mav.addObject("vo", vo);
		
		return mav;
	}
	// insertClient
	@PostMapping(value = "/insertClient")
	public String insertClient(Model model, SurveyContentVO scvo) {
		System.out.println("subcode: "+scvo.getSubcode()+", subtype: "+scvo.getSubtype());
		
		service.updateSurveyCnt(scvo);
		
		return "redirect:list";
	}
}
