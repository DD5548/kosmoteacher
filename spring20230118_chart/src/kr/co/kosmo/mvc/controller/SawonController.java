package kr.co.kosmo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.SawonDaoInter;
import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;
@Controller
public class SawonController {
	@Autowired
	private SawonDaoInter dao;
	
	@GetMapping("deptForm")
	public String deptForm() {
		return "deptForm";
	}
	@PostMapping("/deptList")
	public ModelAndView deptList(int deptno) {
		ModelAndView mav = new ModelAndView("deptList");
		DeptVO vo = dao.getDeptList(deptno);
		mav.addObject("dvo", vo);
		return mav;
	}
	@GetMapping(value = "sphoneList")
	public String sawonPhoneList(Model model) {
		List<SawonVO> list = dao.getSawonList();
		model.addAttribute("slist", list);
		return "sawonPhoneList";
	}
}
