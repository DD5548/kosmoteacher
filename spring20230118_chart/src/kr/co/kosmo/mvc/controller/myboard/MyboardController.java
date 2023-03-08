package kr.co.kosmo.mvc.controller.myboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kosmo.mvc.dao.MyBoardDaoInter;
import kr.co.kosmo.mvc.vo.BoardVO;

@Controller // ÁöÁ¤
@RequestMapping(value = "/board")
public class MyboardController {
	@Autowired
	MyBoardDaoInter dao;
	
	@RequestMapping(value = "/form")
	public String form() {
		return "board/boardForm";
	}
	@RequestMapping(value = "/insert")
	public String insert(BoardVO vo) {
		dao.insertBoard(vo);
		
		return "redirect:/";
	}
	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<BoardVO> list = dao.ListBoard();
		
		model.addAttribute("list", list);
		
		return "board/boardList";
	}
}
