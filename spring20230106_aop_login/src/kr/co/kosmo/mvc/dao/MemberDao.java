package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.LoginLogDTO;
import kr.co.kosmo.mvc.vo.MemberDTO;
// Dao���� @Repository ���(Dao�� ���� ��Ͻ����ش�.) *
// �⺻�� �̱����̴�.
@Repository
public class MemberDao implements MemberDaoInter {
	// kosmo-servlet.xml�� ������ Bean byName
	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void insertMember(MemberDTO vo) {
		// TODO Auto-generated method stub
		ss.insert("member.insert", vo);
	}

	@Override
	public int checkId(String id) {
		// TODO Auto-generated method stub
		int cnt = ss.selectOne("member.checkId", id);
		return cnt;
	}

	@Override
	public MemberDTO checkLogin(MemberDTO vo) {
		// TODO Auto-generated method stub
		MemberDTO vo2 = ss.selectOne("member.login", vo);
		
		return vo2;
	}

	@Override
	public void insertLog(LoginLogDTO vo) {
		// TODO Auto-generated method stub
		ss.insert("member.insertLog", vo);
	}
	
}
