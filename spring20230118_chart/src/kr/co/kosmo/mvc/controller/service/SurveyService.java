package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Service
public class SurveyService {
	// Dao를 단위 처리하기 위한 사비스
	@Autowired
	private SurveyDao dao;
	
	// 모델에서 받아온 각 데이타를 Dao에 각각 전달해서 Transaction(단위) 처리를 하기 위한 메쏘드
	@Transactional // 단위  처리 적용!
	public void insert(SurveyVO vo, List<SurveyContentVO> list) {
		dao.insert(vo); // commit x
		dao.insertContent(list); // commit x
		// commit o
	}
	public SurveyVO detail(int num) {
		return dao.detail(num);
	}
	public void updateSurveyCnt(SurveyContentVO vo) {
		dao.updateSurveyCnt(vo);
	}
	
	public List<SurveyVO> list() {
		return dao.list();
	}
}
