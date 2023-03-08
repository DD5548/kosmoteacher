package mobile.kosmo.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.UploadDTO;
import mobile.kosmo.mvc.dao.UploadDaoInter;

@Controller
public class DefaultMobileController {
	@Autowired
	private UploadDaoInter dao;

	// -------------------------
	private int nowPage = 1;
	private int nowBlock = 1;
	private int totalRecord;
	private int numPerPage = 10;
	private int pagePerBlock = 5;
	private int totalPage;
	private int totalBlock;
	private int beginPerPage;
	private int endPerPage;
	// -------------------------

	@RequestMapping(value = "/")
	public String defaultMPage(Model model, String cPage, String searchType, String searchValue) {
		System.out.println("================Search");
		PageSearchDTO vo = new PageSearchDTO();
		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		System.out.println("searchType =>"+searchType);
		System.out.println("searchValue =>"+searchValue);
		// --------------Page 처리하기
		// 총 게시물 수 가져오기 => 실행결과 TotalRecord :21
		totalRecord = dao.count();
		System.out.println("1. TotalRecord :" + totalRecord);
		// 전체 페이지 출력해보기 => totalPage :2.1
		// double totalPage2 = totalRecord/(double)numPerPage;
		
		// 올림 => 2.1 => 3
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);

		// totalBlock = totalPage/5;
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);

		// 현재 페이지를 요청할 때 파라미터로 현재 페이지값을 받는다. 1 ~~~~~~~ n
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);

		// nowPage의 값에서 SQL문의 #{begin} , #{end} 연산
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// 데이터 전송해보기
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", beginPerPage);
		map.put("end", endPerPage);
		// vo.setBegin(beginPerPage);
		// vo.setEnd(endPerPage);

		List<UploadDTO> list = dao.list(map);

		// 페이지 블록안에 페이지 반복 시키기 위한 startPage , endPage를 구해서
		// view로 전달해야 함.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage의 연산의 범위가 우리가 구한 totalPage값 미만이라면
		// totalPage의 값으로 대입시킨다.
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);

		// View에 forward로 전송할 데이터
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pagePerBlock", pagePerBlock); // 설정된 5
		model.addAttribute("totalPage", totalPage);
		// --------------------------
		
		return "index";
	}
}
