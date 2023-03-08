package kr.co.kosmo.mvc.controller.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kosmo.mvc.dao.UploadDaoInter;
import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.UploadDTO;

@Controller
@RequestMapping(value = "/upload")
public class UploadDemoController {
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

	@GetMapping(value = "/form")
	public String form() {
		return "udemo/form";
	}

	@PostMapping(value = "/uploadpro")
	public String uploadFile(Model model, UploadDTO vo, HttpServletRequest request) {
		// System.out.println("sub: "+vo.getSub());

		String img_path = "resources\\imgfile";

		// request를 가지고 이미지의 경로를 받아서 출력
		String r_path = request.getRealPath("/");
		System.out.println("r_path: " + r_path);

		// 압로드된 이미지의 이름을 받아서 이미지를 복사
		// 이미지 이름 확인
		String oriFn = vo.getMfile().getOriginalFilename();
		System.out.println("oriFn: " + oriFn);

		// 이미지 사이즈 및 contentType 확인
		String contentType = vo.getMfile().getContentType();
		long size = vo.getMfile().getSize();

		System.out.println("파일의 type: " + contentType);
		System.out.println("파일 크기: " + size);

		// 이미지가 저장될 경로 만들기.
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("Full path: " + path);

		// 추상 경로(이미지를 저장할 경로) File 객체로 생성
		File f = new File(path.toString());

		try {
			vo.getMfile().transferTo(f);
			// 이미지 이름을 db에 저장하기 위해서 DTO 값을 재설정
			vo.setImgn(oriFn);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dao.insert(vo);

		return "redirect:list"; // list 이동 예정
	}

	// search일 경우 post 올 수 있으니 method를 설정하지 않음.
	@RequestMapping("/list")
	public String list(Model model, String cPage, PageSearchDTO vo) {
		// -----------------------------------------
		/*
		// 총 게시물 수 가져오기.
		String searchType = request.getParameter("searchType");

		request.setAttribute("searchType", searchType);

		String searchValue = request.getParameter("searchValue");

		request.setAttribute("searchValue", searchValue);

		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		*/

		totalRecord = dao.count();

		System.out.println("1. totalRecord: " + totalRecord);

		// 전체 페이지 출력해보기.
		// double totalPage2 = totalRecord / (double) numPerPage;

		// 올림
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage: " + totalPage);

		// totalBlock = totalPage / 5;
		totalBlock = (int) Math.ceil(totalPage / (double) pagePerBlock);
		System.out.println("3. totalBlock: " + totalBlock);
		
		// 현재 페이지를 요청할 때 파라미타로 현재 페이지 값을 받는다. 1 ~ n
		if (cPage != null) {
			nowPage = Integer.parseInt(cPage);

			System.out.println("4. nowPage: " + nowPage);
		}

		// nowPage의 값에서 SQL 문의 #{begin }, #{end } 연산
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;

		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("6. endPerPage = " + endPerPage);

		// 데이타 전송해보기.
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put("begin", 1);
		// map.put("end", 10);
		
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		
		List<UploadDTO> list = dao.list(vo);

		// 페이지 브락 안에 페이지 반복시키기 위한 startPage, endPage를 구해서
		// view로 전달해야 함. ***
		int startPage = ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;

		// endPage의 연산 범위가 우리가 구한 totalPage 값 미만이라면
		// totalPage의 값으로 대입시킨다.
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		System.out.println("7. startPage: " + startPage);
		System.out.println("8. endPage: " + endPage);
		System.out.println("******************************");
		
		// View에 forward로 전송할 데이타
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pagePerBlock", pagePerBlock);
		model.addAttribute("totalPage", totalPage);
		// -----------------------------------------

		return "udemo/list";
	}
}
