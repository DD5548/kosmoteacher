package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BoardVO;
@Repository
public class MyBoardDao implements MyBoardDaoInter {
	@Autowired
	SqlSessionTemplate ss;
	
	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		ss.insert("myboard.insert", vo);
	}

	@Override
	public List<BoardVO> ListBoard() {
		// TODO Auto-generated method stub
		List<BoardVO> list = ss.selectList("myboard.list");
		
		return list;
	}

	@Override
	public BoardVO detailBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		
	}

}
