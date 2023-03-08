package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Repository
public class SurveyDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public void insert(SurveyVO vo) {
		ss.insert("survey.insert", vo);
	}
	public void insertContent(List<SurveyContentVO> list) {
		ss.insert("survey.insertContent", list);
	}
	public SurveyVO detail(int num) {
		SurveyVO vo = ss.selectOne("survey.detail", num);
		List<SurveyContentVO> list = vo.getSubvey();
		
		System.out.println("SurveyContentVO size: "+list.size());
		
		return vo;
	}
	public void updateSurveyCnt(SurveyContentVO vo) {
		ss.update("survey.updateSurveyCnt", vo);
	}
	// list 구현하기.
	public List<SurveyVO> list() {
		return ss.selectList("survey.list");
	}
}
