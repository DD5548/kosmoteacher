package kr.co.kosmo.mvc.dao;

import kr.co.kosmo.mvc.vo.LoginLogDTO;
import kr.co.kosmo.mvc.vo.MemberDTO;

public interface MemberDaoInter {
	public void insertMember(MemberDTO vo);
	public int checkId(String id);
	// ID�� PW�� vo�� �����ϰ� ��ȯ ������ id, name ���� ��ȯ
	public MemberDTO checkLogin(MemberDTO vo);
	// login �α� ó���� ���� �޽��
	public void insertLog(LoginLogDTO vo);
}
