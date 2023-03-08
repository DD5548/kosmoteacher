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

		// request�� ������ �̹����� ��θ� �޾Ƽ� ���
		String r_path = request.getRealPath("/");
		System.out.println("r_path: " + r_path);

		// �зε�� �̹����� �̸��� �޾Ƽ� �̹����� ����
		// �̹��� �̸� Ȯ��
		String oriFn = vo.getMfile().getOriginalFilename();
		System.out.println("oriFn: " + oriFn);

		// �̹��� ������ �� contentType Ȯ��
		String contentType = vo.getMfile().getContentType();
		long size = vo.getMfile().getSize();

		System.out.println("������ type: " + contentType);
		System.out.println("���� ũ��: " + size);

		// �̹����� ����� ��� �����.
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("Full path: " + path);

		// �߻� ���(�̹����� ������ ���) File ��ü�� ����
		File f = new File(path.toString());

		try {
			vo.getMfile().transferTo(f);
			// �̹��� �̸��� db�� �����ϱ� ���ؼ� DTO ���� �缳��
			vo.setImgn(oriFn);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dao.insert(vo);

		return "redirect:list"; // list �̵� ����
	}

	// search�� ��� post �� �� ������ method�� �������� ����.
	@RequestMapping("/list")
	public String list(Model model, String cPage, PageSearchDTO vo) {
		// -----------------------------------------
		/*
		// �� �Խù� �� ��������.
		String searchType = request.getParameter("searchType");

		request.setAttribute("searchType", searchType);

		String searchValue = request.getParameter("searchValue");

		request.setAttribute("searchValue", searchValue);

		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		*/

		totalRecord = dao.count();

		System.out.println("1. totalRecord: " + totalRecord);

		// ��ü ������ ����غ���.
		// double totalPage2 = totalRecord / (double) numPerPage;

		// �ø�
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage: " + totalPage);

		// totalBlock = totalPage / 5;
		totalBlock = (int) Math.ceil(totalPage / (double) pagePerBlock);
		System.out.println("3. totalBlock: " + totalBlock);
		
		// ���� �������� ��û�� �� �Ķ��Ÿ�� ���� ������ ���� �޴´�. 1 ~ n
		if (cPage != null) {
			nowPage = Integer.parseInt(cPage);

			System.out.println("4. nowPage: " + nowPage);
		}

		// nowPage�� ������ SQL ���� #{begin }, #{end } ����
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;

		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("6. endPerPage = " + endPerPage);

		// ����Ÿ �����غ���.
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put("begin", 1);
		// map.put("end", 10);
		
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		
		List<UploadDTO> list = dao.list(vo);

		// ������ ��� �ȿ� ������ �ݺ���Ű�� ���� startPage, endPage�� ���ؼ�
		// view�� �����ؾ� ��. ***
		int startPage = ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;

		// endPage�� ���� ������ �츮�� ���� totalPage �� �̸��̶��
		// totalPage�� ������ ���Խ�Ų��.
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		System.out.println("7. startPage: " + startPage);
		System.out.println("8. endPage: " + endPage);
		System.out.println("******************************");
		
		// View�� forward�� ������ ����Ÿ
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
