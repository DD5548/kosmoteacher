package kr.co.kosmo.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.MemberDemoVO;

@Controller
public class MemberModelAttrDemo {
	// form�� ���� ���� �޽�带 ���� - forward
	// @RequestMapping(value = "/memberForm", method = RequestMethod.GET)
	@GetMapping(value = "/memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("member/form");
		
		return mav;
	}
	// member�� ó���ϴ� �޽��� �ѵ�� ������ �����Ѵ�.
	// �Ķ��Ÿ ó��: HttpServletRequest request WAS -> DispatcherServlet -> Spring container�� ���ؼ� ���Թ޴´�.
	// @PostMapping(value = "/insertMember")
	public ModelAndView insertMember(HttpServletRequest request) {
		System.out.println("ID -> "+request.getParameter("id"));
		System.out.println("P/W -> "+request.getParameter("pw"));
		System.out.println("Name -> "+request.getParameter("uname"));
		
		ModelAndView mav = new ModelAndView("member/success");
		
		return mav;
	}
	
	// @PostMapping(value = "/insertMember")
	public ModelAndView insertMember(String id, String pw, String uname) {
		System.out.println("ID 2 -> "+id);
		System.out.println("P/W 2 -> "+pw);
		System.out.println("Name 2 -> "+uname);
		
		ModelAndView mav = new ModelAndView("member/success");
		
		return mav;
	}
	
	// @RequestMapping(value = "/insertMember")
	public ModelAndView insertMember(MemberDemoVO vo) {
		System.out.println("ID 3 -> "+vo.getId());
		System.out.println("P/W 3 -> "+vo.getPw());
		System.out.println("Name 3 -> "+vo.getUname());
		
		ModelAndView mav = new ModelAndView("member/success");
		
		mav.addObject("vo", vo);
		
		return mav;
	}
	
	@PostMapping(value = "/insertMember")
	public String insertMember(Model model, MemberDemoVO vo) {
		System.out.println("ID 4 -> "+vo.getId());
		System.out.println("P/W 4 -> "+vo.getPw());
		System.out.println("Name 4 -> "+vo.getUname());
		
		model.addAttribute("vo", vo);
		
		return "member/success";
	}
}
