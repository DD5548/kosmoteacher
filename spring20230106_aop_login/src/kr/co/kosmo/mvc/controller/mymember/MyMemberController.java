package kr.co.kosmo.mvc.controller.mymember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

@Controller
@RequestMapping("/member")
public class MyMemberController {
	@Autowired
	private MemberDaoInter memberDaoInter;
	
	@GetMapping(value = "memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("mymember/form");
		
		return mav;
	}
	// String�� ��쿡�� viewName ����, Model ���ڷ� ���� �� �ִ�.
	@PostMapping(value = "/insertMember")
	public String insertMember(MemberDTO vo) {
		System.out.println("ID: "+vo.getId());
		System.out.println("Age: "+vo.getAge());
		System.out.println("Gender: "+vo.getGender());
		System.out.println("Mdate: "+vo.getMdate());
		// Interface�� ����� �Է� �޽�� ȣ��!
		memberDaoInter.insertMember(vo);
		
		// ȸ�� ������ ������ ���� �̵��� ������ ���� - redirect
		return "redirect:/";
	}
	@GetMapping(value = "/checkId")
	public String checkId(Model model,@RequestParam String id) {
		System.out.println("idAjax: "+id);
		int cnt = memberDaoInter.checkId(id);
		model.addAttribute("msg", cnt);
		return "mymember/checkId";
	}
}
