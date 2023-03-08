package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.LoginLogDTO;
import kr.co.kosmo.mvc.vo.MemberDTO;

public interface MemberDaoInter {
	public void insertMember(MemberDTO vo);
	public int checkId(String id);
	// ID와 PW을 vo로 전송하고 반환 값으로 id, name 등을 반환
	public MemberDTO checkLogin(MemberDTO vo);
	// login 로깅 처리를 위한 메쏘드
	public void insertLog(LoginLogDTO vo);
	// json
	public MemberDTO jsonDmo(String id);
	public List<MemberDTO> listJson();
}
