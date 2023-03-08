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
	// Dao�� ���� ó���ϱ� ���� ���
	@Autowired
	private SurveyDao dao;
	
	// �𵨿��� �޾ƿ� �� ����Ÿ�� Dao�� ���� �����ؼ� Transaction(����) ó���� �ϱ� ���� �޽��
	@Transactional // ����  ó�� ����!
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
