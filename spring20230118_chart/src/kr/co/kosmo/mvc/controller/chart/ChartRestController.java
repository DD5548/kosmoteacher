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

// @Controller -> 스프링 콘테이나가 Model로 선택해서
// 현재 시스템에서는 InternalResourceViewResolver를 통해서 지정한
// View로 forward 방식으로 이동한다.
// @RestController -> CustomView를 사용해서 지정한 View 즉,
// JSP를 사용하지 않고 데이타를 응답할 수 있기 때문에
// 주로 JSON으로 response할 때 주로 사용함.
// @RestController: json과 같은 데이타를 사비스하기 위한 콘트로라다.
// @Controller: 메시지 파일 [/WEB-INF/views/안녕하세요..jsp]을(를) 찾을 수 없습니다.
@RestController
public class ChartRestController {
	@Autowired
	private MemberDaoInter dao;

	// 해당 요청이 오면 가상 View에다가 반환받은 값을 전달해서 응답 처리를 해준다.
	@RequestMapping(value = "/helloView", produces = "text/html;charset=euc-kr")
	public String viewMessage() {
		return "안녕하세요.";
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
			vo.setName("없음.");
			
			return vo;
		}

		/*
		 * // 테스트용 VO에 저장 MemberDTO vo = new MemberDTO(); vo.setName("김길동");
		 * vo.setNo(1); vo.setAge(11); vo.setGender("남자"); vo.setId("big daddy");
		 * vo.setPw("11"); vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new
		 * Date()));
		 */
	}
	// 연습 문제) 회원 전체를 출력하는 JsonView를 만드시오.
	@GetMapping(value = "/listJson", produces = "application/json;charset=utf-8")
	public List<MemberDTO> listJson() {
		List<MemberDTO> list = dao.listJson();
		
		return list;
	}
}
