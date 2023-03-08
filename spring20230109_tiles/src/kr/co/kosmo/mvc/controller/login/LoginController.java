package kr.co.kosmo.mvc.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	MemberDaoInter dao;
	
	@RequestMapping(value = "/form")
	public String form() {
		return "login/form";
	}

	// ������ ���۵Ǿ� �� �Ķ��Ÿ�� ���� �������� ����Ÿ���̽�����
	// ������ ȸ���̸� ������ ���� �����ϰ�, �ƴϸ� ���� �޽����� ������� ���� �ʳ�
	@PostMapping("/login")
	public ModelAndView login(HttpSession session, HttpServletRequest request, MemberDTO vo, @RequestHeader("User-Agent") String userAgent) {
		System.out.println("User-Agent: " + userAgent);

		ModelAndView mav = new ModelAndView("redirect:/");

		// test
		// String dbid = "x man";
		// String dbpw = "1";
		MemberDTO vo2 = dao.checkLogin(vo);
		// if (dbid.equals(vo2.getId()) && dbpw.equals(vo.getPw())) {
		if(vo2 != null) {
			session.setAttribute("sessionName", vo2.getName());
			session.setAttribute("sessionID", vo2.getId());
		} else {
			mav.addObject("emsg", "Login �����Դϴ�.");
			mav.setViewName("error/paramException");
		}

		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest request, @RequestHeader("User-Agent") String userAgent) {
		ModelAndView mav = new ModelAndView("redirect:/");
		// session.invalidate();
		session.removeAttribute("sessionName");
		session.removeAttribute("sessionID");

		mav.setViewName("redirect:/");
		System.out.println("Logout ���� �� ���� ���� -> Proceeding Call!");

		return mav;

	}
}
