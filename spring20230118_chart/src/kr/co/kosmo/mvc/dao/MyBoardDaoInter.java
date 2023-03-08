package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.BoardVO;

public interface MyBoardDaoInter {
	public void insertBoard(BoardVO vo);
	public List<BoardVO> ListBoard();
	public BoardVO detailBoard(int num);
	public void deleteBoard(int num);
}
