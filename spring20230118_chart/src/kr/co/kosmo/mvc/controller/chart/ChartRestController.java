package kr.co.kosmo.mvc.controller.chart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

// @Controller -> ������ �����̳��� Model�� �����ؼ�
// ���� �ý��ۿ����� InternalResourceViewResolver�� ���ؼ� ������
// View�� forward ������� �̵��Ѵ�.
// @RestController -> CustomView�� ����ؼ� ������ View ��,
// JSP�� ������� �ʰ� ����Ÿ�� ������ �� �ֱ� ������
// �ַ� JSON���� response�� �� �ַ� �����.
// @RestController: json�� ���� ����Ÿ�� ����ϱ� ���� ��Ʈ�ζ��.
// @Controller: �޽��� ���� [/WEB-INF/views/�ȳ��ϼ���..jsp]��(��) ã�� �� �����ϴ�.
@RestController
public class ChartRestController {
	@Autowired
	private MemberDaoInter dao;

	// �ش� ��û�� ���� ���� View���ٰ� ��ȯ���� ���� �����ؼ� ���� ó���� ���ش�.
	@RequestMapping(value = "/helloView", produces = "text/html;charset=euc-kr")
	public String viewMessage() {
		return "�ȳ��ϼ���.";
	}

	// Json Object Type -> javascript Object
	@RequestMapping(value = "/deptJsonView", produces = "application/json;charset=utf-8")
	public MemberDTO jsonObjectDemo(String id) {
		System.out.println("id -> " + id);

		try {
			MemberDTO vo = dao.jsonDmo(id);
			
			return vo;
		} catch (Exception e) {
			// TODO: handle exception
			MemberDTO vo = dao.jsonDmo(id);
			vo.setName("����.");
			
			return vo;
		}

		/*
		 * // �׽�Ʈ�� VO�� ���� MemberDTO vo = new MemberDTO(); vo.setName("��浿");
		 * vo.setNo(1); vo.setAge(11); vo.setGender("����"); vo.setId("big daddy");
		 * vo.setPw("11"); vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new
		 * Date()));
		 */
	}
	// ���� ����) ȸ�� ��ü�� ����ϴ� JsonView�� ����ÿ�.
	@GetMapping(value = "/listJson", produces = "application/json;charset=utf-8")
	public List<MemberDTO> listJson() {
		List<MemberDTO> list = dao.listJson();
		
		return list;
	}
}
