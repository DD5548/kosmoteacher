package kr.co.kosmo.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.BoardVO;

@Controller
public class BoardController {
	// 1. boardForm
	@RequestMapping(value = "/boardForm")
	public ModelAndView boardForm() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}

	// ----------------------------------------------------------------------------------
	// 2. boardIn
	/*
	 * ModelAndView mav = new ModelAndView System.out.println("ID3 => "+vo.getId());
	 * System.out.println("PWD3 => "+vo.getPwd());
	 */
	@RequestMapping(value = "/boardIn", method = RequestMethod.POST)
	public ModelAndView boardIn(BoardVO vo) {
		System.out.println("title => " + vo.getTitle());
		System.out.println("content => " + vo.getContent());
		System.out.println("writer => " + vo.getWriter());
		ModelAndView mav = new ModelAndView("redirect:boardList");
		
		return mav;
	}

	// ----------------------------------------------------------------------------------
	// 3. boardlist
	/*
	 * List<BoardVO> list = new ArrayList<BoardVO>(); �ӽõ����� ���� ������ board/boardList
	 */
	@RequestMapping(value = "/boardList")
	public ModelAndView boardlist() {
		ModelAndView mav = new ModelAndView("board/boardList");
		List<BoardVO> list = new ArrayList<BoardVO>();
		// �ӽõ����� �����
		for (int i = 0; i < 10; i++) {
			BoardVO vo = new BoardVO();
			vo.setNum(i);
			vo.setTitle("��" + i);
			vo.setWriter("��" + i);
			vo.setBdate("��¥" + i);
			list.add(vo);
		}
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value = "/boardDetail")
	public ModelAndView boardDetail(int num) {
		ModelAndView mav = new ModelAndView("board/boardDetail");
		BoardVO vo = null;
		
		// �ӽõ����� �����
		for (int i = 0; i < 10; i++) {
			if(i == num) {
			vo = new BoardVO();
			vo.setNum(i);
			vo.setTitle("��" + i);
			vo.setContent("��"+i);
			vo.setWriter("��" + i);
			vo.setBdate("��¥" + i);
			vo.setReip("��"+i);
			}
		}
		mav.addObject("vo", vo);
		
		return mav;
	}
}
