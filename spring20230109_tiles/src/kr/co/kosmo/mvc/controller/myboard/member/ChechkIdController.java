package kr.co.kosmo.mvc.controller.myboard.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
// RestController: Json�� ī���� ��� �����ϱ� ���� ����
@RestController
public class ChechkIdController {
	@Autowired
	private MemberDaoInter dao;
	// �ݵ�� id�� �־�� �Ѵ�.
	@GetMapping(value = "/checkId")
	public int checkId(Model model, @RequestParam String id) {
		System.out.println("idAjax: "+id);
		int cnt = dao.checkId(id);
		model.addAttribute("msg", cnt);
		return cnt;
	}
}
